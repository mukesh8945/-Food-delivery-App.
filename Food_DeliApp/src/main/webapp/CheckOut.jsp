<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Insert title here</title>
    <link rel="stylesheet" type="text/css" href="CheckOut.css">
</head>
<body>
    <div class="navbar">
        <a href="HomePage">Home</a>
        <a href="Login.jsp">Login</a>
        <a href="SignUp.jsp">Sign Up</a>
    </div>

    <div class="main-container">
        <div id="checkout-container">
            <h2>Check Out</h2>
            <form action="Checkout" method="post">
                <label for="address">Delivery Address</label>
                <textarea id="address" name="address" required></textarea>
                <br> <br>
                <label for="paymentMethod">Payment Method</label>
                <select id="paymentMethod" name="paymentMethod">
                    <option value="Online">Credit Card</option>
                    <option value="Online">Debit Card</option>
                    <option value="Cash">Cash On Delivery</option>
                </select>
                <br> <br>
                <input type="submit" value="Place Order">
            </form>
        </div>
    </div>
</body>
</html>
