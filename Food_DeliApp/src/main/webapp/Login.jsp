<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.io.*,java.util.*,java.sql.*,javax.servlet.*"%>
<%@ page import="javax.servlet.http.*,javax.servlet.annotation.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>LogIn</title>
<link rel="stylesheet" href="Login.css">
<link href='https://unpkg.com/boxicons@2.1.4/css/boxicons.min.css'
	rel='stylesheet'>
</head>
<body>

	<div class="wrapper">
		<form action="loginForm" method="post">
			<h1>Login</h1>
			<div class="input-box">
				<input type="text" placeholder="Username" name="Username" required>
				<i class='bx bxs-user'></i>
			</div>

			<div class="input-box">
				<input type="text" placeholder="Password" name="Password" required>
				<i class='bx bxs-lock-alt'></i>
			</div>
			<button type="submit" class="btn">LogIn</button>


			<div class="register-link">
				<p>
					Don't have an account?<a href="SignUp.jsp">SignUp</a>
				</p>
			</div>


		</form>
	</div>
	</form>
</body>
</html>