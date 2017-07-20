<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>MUM Store</title>

<link href="<c:url value='/resources/css/styles.css'/>" rel="stylesheet" />
<link href="<c:url value='/resources/css/bootstrap-reboot.min.css'/>"
	rel="stylesheet" />
<link href="<c:url value='/resources/css/bootstrap-grid.min.css'/>"
	rel="stylesheet" />
<link href="<c:url value='/resources/css/bootstrap.min.css'/>"
	rel="stylesheet" />
<link
	href="//netdna.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css">
</head>
<body>

	<div id="header">

	<div id="logo">
		<a href="index"> <img id="cartIcon"
				alt="cart"
				src="${pageContext.request.contextPath}/resources/images/home.png" />  </a>
	</div>

		<div id="cartDiv">
			<c:if test='${user == null}'>
				<a class="header" href="login">Login</a>
			</c:if>
			<c:if test="${user != null}">
				<a class="header" href="account">Account</a> <a class="header" href="shoppinghistory">Order History</a> <a class="header" href="login?action=signout">Logout</a>	
			</c:if>
			
			<c:if test="${user.type != 'MANAGER'}">
			
			<form id="checkoutForm" action="checkout" onsubmit="return valiData();">
			
			
			<button type="submit" class="cartLabel" ><img id="cartIcon"
				alt="cart"
				src="${pageContext.request.contextPath}/resources/images/checkout.png" />
				
								<c:set var="totalAmount" value="${0}" />
                                  <c:forEach var="item" items="${cart.getAllCartItems()}">
                                  
									  <c:set var="totalAmount" value="${totalAmount + (item.quantity)}" />
									
								  </c:forEach>
				
				
				<label class="cartLabel" id="currentCart">${totalAmount} </label>&nbsp;<label
				class="cartLabel">Items</label> </button>
			
			</form>
			
			
				
			</c:if>
			
		
		</div>
	</div>