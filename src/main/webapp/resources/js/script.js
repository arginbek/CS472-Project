$(function() {
	$('#btn_add').click(addProduct);

	function addProduct() {
		$.post('product', {
			name : $('#product_name').val(),
			price : $('#product_price').val()
		}, processData)
	}

	function processData(data) {
		data = JSON.parse(data);
		var td0 = $('<td>').text(data.id);
		var td1 = $('<td>').text(data.name);
		var td2 = $('<td>').text(data.price);
		var tr = $('<tr>').append(td0).append(td1).append(td2);
		$('#tbl_products>tbody').append(tr);
	}
	
//	Mustafa
	
	$('#list').click(function(event) {
		event.preventDefault();
		$('#products .item').addClass('list-group-item');
	});
	$('#grid').click(function(event) {
		event.preventDefault();
		$('#products .item').removeClass('list-group-item');
		$('#products .item').addClass('grid-group-item');
	});

	$("#addToCart").click(printSession);

	
})

$('.message a').click(function() {
	$('form').animate({
		height : "toggle",
		opacity : "toggle"
	}, "slow");
});


function printSession() {

	
	var value = '<%= session.getAttribute("g") %>'
	console.log("good")
	alert(value);
}
