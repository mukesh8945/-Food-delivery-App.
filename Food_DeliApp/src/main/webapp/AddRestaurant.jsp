<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Add Restaurant - QuickBite Express</title>
    <!-- Link to your existing CSS file -->
    <link rel="stylesheet" type="text/css" href="AddRestaurant.css">
    <!-- Add the styles for the form -->
    
</head>
<body>

    <div class="main-container">
        <form action="AddRestaurantServlet" method="post">
            <label for="name">Name:</label>
            <input type="text" id="name" name="name" required><br>

			<label for="cuisineType">Cuisine Type:</label>
			<select id="cuisineType" name="cuisineType" required>
			    <option value="Indian">South Indian</option>
			    <option value="Indian">North Indian</option>
			    <option value="Chinese">Chinese</option>
			    <option value="French">French</option>
			    <option value="Japanese">Japanese</option>
			    <option value="Mexican">Mexican</option>
			    <option value="Thai">Thai</option>
			    <option value="American">American</option>
			    <option value="MiddleEastern">Middle Eastern</option>
			</select><br>

            <label for="deliveryTime">Delivery Time (minutes):</label>
            <input type="number" id="deliveryTime" name="deliveryTime" required><br>

            <label for="address">Address:</label>
            <input type="text" id="address" name="address" required><br>
            
            <label for="adminUserId">Admin User ID:</label>
			<input type="number" id="adminUserId" name="adminUserId" required><br>
               
            <label for="rating">Rating:</label>
            <input type="number" id="rating" name="rating" step="0.1" required><br>

            <label for="isActive">Is Active:</label>
            <input type="checkbox" id="isActive" name="isActive" checked><br>

            <label for="imagePath">Image Path:</label>
            <input type="text" id="imagePath" name="imagePath"><br>

            <!-- You may add fields for menu items if needed -->

            <input type="submit" value="Add Restaurant">
        </form>
    </div>

</body>
</html>
