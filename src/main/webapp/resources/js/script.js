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
	
	
	
	$(".btn").click(addToCart);
	
	function addToCart() {
		$.post('index', {
			name : $('#name').val(),
			price : $('#price').val(),
			id: $('#id').val()
		}, updateCart)
	}
	
	function updateCart(data){
		console.log("Called")
		
		var currentItems = $("#currentCart").text();
		
		console.log(currentItems);
		
		$("#currentCart").text(parseInt(currentItems)+1+"");
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


	
})

$('.message a').click(function() {
	$('form').animate({
		height : "toggle",
		opacity : "toggle"
	}, "slow");
});

