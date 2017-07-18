<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="resources/js/manageinventory.js"></script>
<link rel="stylesheet" type="text/css" href="resources/css/manageinventory.css">
<title>Manage Inventory</title>
</head>
<body>
	<h1>All products list</h1>
	<c:forEach items="${inventory}" var="item">
		<div>
			<p>
				<img src="resources/images/${item.product.imgName}"
					alt="${item.product.imgName}" class="productImg"/> 
				<strong>${item.product.name}</strong><br/>
				<label>Price: $<input type="text" name="price${item.product.id}" value="${item.product.price}" id="price${item.product.id}" class="productPrice"/></label>
				<label>Quantity: $<input type="text" name="quantity${item.product.id}" value="${item.quantity}" id="quantity${item.product.id}" class="productQuantity"/></label><br/>
				<button type="button" id="${item.product.id}" class="btnUpdate">Save</button><a id="a${item.product.id}"></a><br/>
				<a>${item.product.description}</a>
			</p>
		</div><br/>
	</c:forEach>
</body>
</html>