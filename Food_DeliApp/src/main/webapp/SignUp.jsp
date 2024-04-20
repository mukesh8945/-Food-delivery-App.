<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ page import="java.io.*,java.util.*,java.sql.*,javax.servlet.*" %>
	<%@ page import="javax.servlet.http.*,javax.servlet.annotation.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>SignUp</title>
<link rel="stylesheet" href="SignUp.css">
</head>
<body>
	<div class="wrapper">
		<form action="signUpForm" method="post">
	    <h1>SignUp</h1>
	
	    <div class="input-box">
	        <input type="text" placeholder="Username" name="Username" required>
	    </div>
	
	    <div class="input-box">
	        <input type="text" placeholder="Password" name="Password" required>
	    </div>
	
	    <div class="input-box">
	        <input type="text" placeholder="Email" name="Email" required>
	    </div>
	
	    <div class="input-box">
	        <input type="text" placeholder="Address" name="Address" required>
	    </div>
	
	    <label for="role">Select Role:</label>
	    <select name="role" id="role" class="dropdown">
	        <option value="Customer">Customer</option>
		    <option value="RestaurantAdmin">Restaurant Admin</option>
		    <option value="SystemAdmin">System Admin</option>
		</select>
	
	    <br><br>
	    <button type="submit" class="btn">Submit</button>
	</form>
</body>
</html>