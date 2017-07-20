<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Edit Account Info</title>
<script type="text/javascript"
	src="<c:url value='/resources/js/jquery-3.2.1.min.js'/>"></script>
<script type="text/javascript"
	src="<c:url value='/resources/js/account.js'/>"></script>
<link href="<c:url value='/resources/css/edit_account.css'/>"
	rel="stylesheet">
</head>
<body>
	<div id="bodydiv">
		First name: <input type="text" id="firstname" name="firstname"
			pattern="[A-Za-z]+" required> <br /> <br /> Last name: <input
			type="text" id="lastname" name="lastname" pattern="[A-Za-z]+"
			required> <br /> <br />
			<button type="button" id="save_btn" >Save</button> 
	</div>
</body>
</html>