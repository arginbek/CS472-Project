<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
  
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>MUM Store</title>

 <link href="<c:url value='/resources/css/styles.css'/>" rel="stylesheet"/>
    <link href="<c:url value='/resources/css/bootstrap-reboot.min.css'/>" rel="stylesheet"/>
    <link href="<c:url value='/resources/css/bootstrap-grid.min.css'/>" rel="stylesheet"/>
    <link href="<c:url value='/resources/css/bootstrap.min.css'/>" rel="stylesheet"/>
</head>
<body>

<div id="header">
	
<div id="cartDiv">
	<a class="cartLabel" href="#" ><img  id="cartIcon" alt="cart" src="${pageContext.request.contextPath}/resources/images/checkout.png"/><label class="cartLabel" id="currentCart">0 </label>&nbsp;<label class="cartLabel">Items</label> </a>	
</div> 
</div>
