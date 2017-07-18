$(function(){
	$('#btn_add').click(addProduct);
	
	function addProduct(){
		$.post('product',{name:$('#product_name').val(), price:$('#product_price').val()}, processData)
	}
	
	function processData(data){
		data = JSON.parse(data);
		var td0=$('<td>').text(data.id);
		var td1 = $('<td>').text(data.name);
		var td2 = $('<td>').text(data.price);
		var tr = $('<tr>').append(td0).append(td1).append(td2);
		$('#tbl_products>tbody').append(tr);
	}
})

