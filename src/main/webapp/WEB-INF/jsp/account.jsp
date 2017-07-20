<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<script type="text/javascript"
	src="<c:url value='/resources/js/jquery-3.2.1.min.js'/>"></script>
<script type="text/javascript"
	src="<c:url value='/resources/js/account.js'/>"></script>
<link href="<c:url value='/resources/css/account.css'/>"
	rel="stylesheet">
<title>MUM Store</title>
</head>
<body>
	<div id="profile">
		<table>
			<tr>
				<td class="image"><script>
					document
							.write("<img src='http://assets-s3.usmagazine.com/uploads/assets/celebrities/238-brad-pitt/1250530894_brad_pitt_290x402.jpg'>")
				</script></td>
			</tr>
			<tr>
				<td id="fname">First name: ${user.firstName}</td>
			</tr>
			<tr>
				<td id="lname">Last name: ${user.lastName}</td>
			</tr>
			<tr>
				<td>User name: ${user.userName}</td>
			</tr>
			<tr>
				<td>Email: ${user.email}</td>
			</tr>
			<tr>
				<td>
					<button id="edit_btn">Edit</button>
				</td>
			</tr>
		</table>
	</div>
</body>
</html>