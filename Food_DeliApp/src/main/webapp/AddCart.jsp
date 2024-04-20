<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.List"%>
<%@ page import="com.food.model.CartItem"%>
<%@ page import="com.food.model.Cart"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Shopping Cart</title>
<link rel="stylesheet" type="text/css" href="AddCart.css">
</head>
<body>

	<div class="navbar">
		<a href="#">Home</a> <a href="Login.jsp">Login</a> <a
			href="SignUp.jsp">Sign Up</a>
	</div>

	<div class="center-container">
		<div class="cart-box">
			<h2>Your Shopping Cart</h2>

			<div class="cart-container">
				<%
				Cart cart = (Cart) session.getAttribute("cart");

				if (cart != null && !cart.getItems().isEmpty()) {
					for (CartItem cartItem : cart.getItems().values()) {
				%>
				<div class="cart-item">
					<!-- Add image path -->

					<h3><%=cartItem.getName()%></h3>

					<p>
						&#36;
						<%=cartItem.getPrice()%></p>

					<form action="AddToCartServelet" method="post">
						<input type="hidden" name="itemId"
							value="<%=cartItem.getItemId()%>"> <input type="hidden"
							name="quantity" value="<%=cartItem.getQuantity()%>">
						<!-- Update -->
						<input type="hidden" name="action" value="update"> <label>Quantity:</label>
						<input type="number" name="quantity"
							value="<%=cartItem.getQuantity()%>" min="1"> <input
							type="submit" value="Update" class="update-btn">
					</form>

					<form action="AddToCartServlet" method="post">
						<input type="hidden" name="itemId"
							value="<%=cartItem.getItemId()%>"> <input type="hidden"
							name="action" value="remove"> <input type="submit"
							value="Remove" class="remove-btn">
					</form>
				</div>
				<%
				}
				} else {
				%>
				<p>Your cart is empty.</p>
				<%
				}
				%>
			</div>

			<a href="Menu?restaurantId=<%=session.getAttribute("restaurantId") %>"
    	class= "addmore">
    		<button >Add More Items</button>
    	</a>


			<!-- Checkout button -->
			<%
			if (cart != null && !cart.getItems().isEmpty()) {
			%>
			<form action="CheckOut.jsp">
				<input type="submit" value="Proceed to Checkout"
					class="btn proceed-to-checkout">
			</form>
			<%
			}
			%>
		</div>
	</div>

</body>
</html>
