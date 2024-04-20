<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Add Menu - QuickBite Express</title>
    <link rel="stylesheet" type="text/css" href="AddMenu.css">
</head>
<body>

    <div class="main-container">
        <form action="AddMenuServlet" method="post">
            <label for="restaurantId">Restaurant ID:</label>
            <input type="number" id="restaurantId" name="restaurantId" required><br>

            <label for="itemName">Item Name:</label>
            <input type="text" id="itemName" name="itemName" required><br>

            <label for="description">Description:</label>
            <textarea id="description" name="description" required></textarea><br>

            <label for="price">Price:</label>
            <input type="number" id="price" name="price" step="0.01" required><br>

            <label for="isAvailable">Is Available:</label>
            <input type="checkbox" id="isAvailable" name="isAvailable" checked><br>

            <label for="imagePath">Image Path:</label>
            <input type="text" id="imagePath" name="imagePath"><br>

            <input type="submit" value="Add Menu">
        </form>
    </div>

</body>
</html>
