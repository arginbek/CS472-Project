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
	src="<c:url value='/resources/js/login.js'/>"></script>
<link href="<c:url value='/resources/css/login.css'/>" rel="stylesheet">
<title>WebStore - Login</title>
</head>
<body>
	<div class="login-wrap">
		<div class="login-html">
			<input id="tab-1" type="radio" name="tab" class="sign-in" checked><label
				for="tab-1" class="tab">Sign In</label> <input id="tab-2"
				type="radio" name="tab" class="sign-up"><label for="tab-2"
				class="tab">Sign Up</label>
			<div class="login-form">
				<div class="sign-in-htm">
					<form method="post" action="login?action=signin">
						<div class="group">
							<label for="user" class="label">Username</label> <input id="user"
								name="username" type="text" class="input">
						</div>
						<div class="group">
							<label for="pass" class="label">Password</label> <input id="pass"
								name="password" type="password" class="input"
								data-type="password">
						</div>
						<div class="group">
							<input id="check" type="checkbox" class="check" checked>
							<label for="check"><span class="icon"></span> Remember me</label>
						</div>
						<div class="group">
							<label class="label">${errorMessage.detail}</label>
						</div>
						<div class="group">
							<input id="sign_in" type="submit" class="button" value="Sign In">
						</div>
					</form>
					<div class="hr"></div>
					<div class="foot-lnk">
						<a href="#forgot">Forgot Password?</a>
					</div>
				</div>

				<div class="sign-up-htm">
					<form method="post" action="login?action=signup">
						<div class="group">
							<label for="first" class="label">First name</label> <input
								name="first" type="text" class="input" pattern="[A-Za-z]+"
								required>
						</div>
						<div class="group">
							<label for="last" class="label">Last name</label> <input
								name="last" type="text" class="input" pattern="[A-Za-z]+" required>
						</div>
						<div class="group">
							<label for="user" class="label">Username</label> <input id="user"
								type="text" name="username" class="input" required>
						</div>
						<div class="group">
							<label for="pass" class="label">Password</label> <input id="pass"
								name="pass1" pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{6,}"
								type="password" class="input" data-type="password" required>
						</div>
						<div class="group">
							<label for="pass" class="label">Repeat Password</label> <input
								id="pass" name="pass2"
								pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{6,}" type="password"
								class="input" data-type="password" required>
						</div>
						<div class="group">
							<label for="pass" class="label">Email Address</label> <input
								id="pass" name="email" type="email" class="input" required>
						</div>
						<div class="group">
							<label class="label">${signupError.detail}</label>
						</div>
						<div class="group">
							<input type="submit" class="button" value="Sign Up">
						</div>
					</form>

					<div class="hr"></div>
					<div class="foot-lnk">
						<label for="tab-1">Already Member?</label>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>