$(function() {
	$('.btnUpdate').click(updateProduct);
	$('.btnDelete').click(deleteProduct);

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
