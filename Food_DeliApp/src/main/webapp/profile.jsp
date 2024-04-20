<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3 style=color:green>Welcome : ${session_name}</h3>
	 <form action="HomePage" method="get">
        <input type="submit" value="Go to Home Page">
    </form>
</body>
</html>