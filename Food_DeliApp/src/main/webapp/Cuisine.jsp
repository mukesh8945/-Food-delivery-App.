<!-- home.jsp -->
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <!-- Add your styles and scripts here -->
</head>
<body>
    <h1>Welcome to the Food Delivery App</h1>

    <c:forEach var="cuisineEntry" items="${groupedFoodItems}">
        <h2>${cuisineEntry.key}</h2>
        <ul>
            <c:forEach var="foodItem" items="${cuisineEntry.value}">
                <li>${foodItem.name} - ${foodItem.description}</li>
            </c:forEach>
        </ul>
    </c:forEach>

    <!-- Add more content as needed -->
</body>
</html>
