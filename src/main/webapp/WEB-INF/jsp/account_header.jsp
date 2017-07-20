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

		<div id="cartDiv">
			<c:if test="${user != null}">
				<a class="header" href="login?action=signout">Logout</a>	
			</c:if>
		</div>
	</div>