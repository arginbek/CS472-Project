$(function() {
	$('.btnUpdate').click(updateProduct);

	function updateProduct(e) {
		$.post('manageinventory', {
			action : 'update',
			id : e.target.id,
			price : $('#price' + e.target.id).val(),
			quantity : $('#quantity' + e.target.id).val()
		}, callbackUpdate);
	}

	function callbackUpdate(data) {
		data = JSON.parse(data);
		if (data === "") {
			$('#a' + data.id).text("Error.");
			$('#a' + data.id).removeClass("prodMsgSuccess");
			$('#a' + data.id).addClass("prodMsgError");
		} else {
			$('#a' + data.id).text("Saved.");
			$('#a' + data.id).removeClass("prodMsgError");
			$('#a' + data.id).addClass("prodMsgSuccess");
		}
	}
})
