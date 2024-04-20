<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.food.daoImpl.OrderDAOImpl"%>
<%@ page import="com.food.model.Order"%>
<%@ page import="java.util.List"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Order Confirmation</title>
</head>
<body>
	<h1>Order Confirmation</h1>
	<%
	Order order = (Order) session.getAttribute("order");
	if (order != null) {
	%>
	<div class="order-details">
		<p>Thank you for your order</p>
		<p>
			OrderId:
			<%=order.getOrderID()%></p>
		<p>
			Total Amount:
			<%=order.getTotalAmount()%></p>
		<p>
			Status:
			<%=order.getStatus()%></p>
		<p>
			Payment Method:
			<%=order.getPaymentMethod()%></p>
	</div>
	<%
	} else {
	%>
	<p>No order found.</p>
	<%
	}
	%>
</body>
</html>
