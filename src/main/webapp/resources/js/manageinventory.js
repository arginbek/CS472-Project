$(function() {
	var productNewID = "";
	$('.btnUpdate').click(updateProduct);
	$('.btnDelete').click(deleteProduct);
	$('#newBtnCreate').click(createProduct);
	$('#upload-form').on('submit', (function(e) {
		e.preventDefault();
		// Create an FormData object
		var formData = new FormData(this);

		$.ajax({
			type : 'POST',
			url : $(this).attr('action'),
			data : formData,
			cache : false,
			contentType : false,
			processData : false,
			success : function(data) {
				productNewID = data;
				alert("File has been uploaded successfully");
			},
			error : function(data) {
				console.log("Error.");
				console.log(data);
			}
		});

		// $.post($(this).attr("action"), data, function(data1) {
		// productNewID = data1;
		// alert("File has been uploaded successfully");
		// });
	}));

	$("#newImage").on("change", function() {
		$('#upload-form').submit();
	});

	function createProduct(e) {
		// \$[1-9]\d{5,}\.\d{2}
		var pattPrice = new RegExp(/^\$?[\d,]+(\.\d*)?$/);
		var pattQty = new RegExp(/^0$|^[1-9][0-9]*$/);

		if (pattPrice.test($('#newPrice').val())) {
			if (pattQty.test($('#newQuantity').val())) {
				$.post('inventory', {
					action : 'create',
					quantity : $('#newQuantity').val(),
					product : "{"
							+ "\"id\" : \""
							+ productNewID
							+ "\","
							+ "\"name\" : \""
							+ $('#newName').val()
							+ "\","
							+ "\"description\" : \""
							+ $('#newDescription').val()
							+ "\","
							+ "\"price\" : \""
							+ $('#newPrice').val()
							+ "\","
							+ "\"imgName\" : \""
							+ (productNewID === "" ? 'noimage.jpg' : 'product'
									+ productNewID + '.jpg') + "\"" + "}"
				}, callbackCreate);
			}else{
				alert("Please input correct quantity! It is integer.");
			}
		}else{
			alert("Please input correct price! It is number.");
		}
	}

	function deleteProduct(e) {
		if (confirm('Are you sure?')) {
			$.post('inventory', {
				action : 'delete',
				id : e.target.id
			}, callbackDelete);
		} else {

		}
	}

	function updateProduct(e) {
		$.post('inventory', {
			action : 'update',
			id : e.target.id,
			price : $('#price' + e.target.id).val(),
			quantity : $('#quantity' + e.target.id).val()
		}, callbackUpdate);
	}

	function callbackCreate() {
		location.reload();
	}

	function callbackDelete(data) {
		data = data.split(",");
		if (data[0] === "Deleted") {
			$("#divProduct" + data[1]).remove();
		} else {
			$('.amsg').text("");
			$('#a' + data[1]).text(data[0]);
			$('#a' + data[1]).removeClass("prodMsgSuccess");
			$('#a' + data[1]).addClass("prodMsgError");
		}
	}

	function callbackUpdate(data) {
		data = JSON.parse(data);
		if (data === "") {
			$('.amsg').text("");
			$('#a' + data.id).text("Error.");
			$('#a' + data.id).removeClass("prodMsgSuccess");
			$('#a' + data.id).addClass("prodMsgError");
		} else {
			$('.amsg').text("");
			$('#a' + data.id).text("Saved.");
			$('#a' + data.id).removeClass("prodMsgError");
			$('#a' + data.id).addClass("prodMsgSuccess");
		}
	}
})
