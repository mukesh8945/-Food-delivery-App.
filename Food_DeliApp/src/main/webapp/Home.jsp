<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.food.daoImpl.RestaurantDAOImpl"%>
<%@ page import="com.food.model.Restaurant"%>
<%@ page import="java.util.List"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!-- title icon -->
<link rel="icon"
	href="data:image/png;base64,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">

<link rel="stylesheet" href="Home.css">
<link
	href="https://fonts.googleapis.com/css2?family=Noto+Sans:wght@100;200&display=swap"
	rel="stylesheet">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css"
	integrity="sha512-iBBXm8fW90+nuLcSKlbmrPcLa0OT92xO1BIsZ+ywDWZCvqsWgccV3gFoRBv0z+8dLJgyAHIhR35VZc2oM/gI1w=="
	crossorigin="anonymous" referrerpolicy="no-referrer" />
<title>Bite Burst</title>
</head>
<body>
	<!--  --header---->
	<header>
		<div class="nav">
			<ul class="nav-bar">
			<li><a href="HomePage"
					style="text-decoration: none; color: inherit;">Home</a></li>
				<li><a href="AddRestaurant.jsp"
					style="text-decoration: none; color: inherit;">Add Restaurants</a></li>
				<li><a href="Login.jsp"
					style="text-decoration: none; color: inherit;">Login</a></li>
				<li><a href="SignUp.jsp"
					style="text-decoration: none; color: inherit;">Signup</a></li>

			</ul>
		</div>
		<div class="head">
			<h1>Bite Burst</h1>
			<h3>Delight your taste buds with Bite Burst</h3>
			<div class="search">
				<p>Btm,Phase-2,7th Main</p>
				<input type="text" placeholder="serach for restaurants">
			</div>
		</div>

		<div class="header-image">
			<img
				src="https://images.unsplash.com/photo-1497888329096-51c27beff665?q=80&w=2071&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D.jpg">

		</div>
	</header>


	<!-- main dashboard -->
	<div class="dashboard">


		<h3 class="dashboard-title">Recommended Restaurants For You</h3>
		<div class="dashboard-menu">
			<a href="#">North Indian</a> <a href="#">South Indian</a> <a href="#">Chinese</a>
			<a href="#">Contineltal</a> <a href="#">Top Rated</a> <a href="#">All</a>
		</div>

		<!--dashboard_content-->

		<div class="dashboard-content">
			<%
			List<Restaurant> restaurants = (List<Restaurant>) request.getAttribute("restaurantList");
			if (restaurants != null)
				for (Restaurant restaurant : restaurants) {
			%>
			<div class="dashboard-card">
			<a href="Menu?restaurantId=<%=restaurant.getRestaurantID()%>">
				 <img class="card-image"
					src="<%=restaurant.getImagePath()%>">
				</a>
				<div class="card-details">
					<h4><%=restaurant.getName()%><Span><%=restaurant.getCuisineType()%></Span>
					</h4>
					<p><%=restaurant.getAddress()%></p>
					<p class="card-time">
						<span class="fas fa-clock"></span><%=restaurant.getDeliveryTime()%>
					</p>		
				</div>
			</div>
			<%
			}
			%>
		</div>
	</div>
</body>
</html>