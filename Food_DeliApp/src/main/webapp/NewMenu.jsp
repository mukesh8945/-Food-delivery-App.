<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ page import="com.food.daoImpl.MenuDAOImpl"%>
<%@ page import="com.food.model.Menu"%>
<%@ page import="java.util.List"%>
<%@ page import="java.util.Map"%>

<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Menu Page</title>
    <link rel="icon" href="data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAOEAAADhCAMAAAAJbSJIAAABSlBMVEX///8A2+YjHyAAgaf9/NzwcWckAAD+2bfpMCMjHR0hLzcKyNIAhq0fGxwyLy8IAAAlEQf/3rsAAAD//+MH0twNGRyjUUoWEBX3dGoXHB0SDA10PjuMi4t7eWsMDBOljXgGfKATo6siJCiLR0MkFxMkDw8TYn4WgYeWlZWlpKQjGBkAHiAUjpUkExO8u7sKAAzlMCNAPT5VUlPt7e0UVm0aFRYcV1vX1rvw79FST0geR0rVLiMQHiB2dXVoZmfd3NwcPUoMbIsZS15ZMjAgMjTGxcXDwaoJvceSkYBxb2Okoo/V1Lq0s53wza0NrrfFqZBwJSG7LCJHIiAYdXvia2K7W1Q7KChSMC5LSUkbZGljYFeKh3gfQURgXV6wr6+1WVKbTUjcvJ9uX1OCb2Cwl4GVgG6FJyFKPzldIyGZKCKrKiJWIiHJLSKjKSInIfLBAAAM+ElEQVR4nO2d61/aSBfHa6Q8Bg3oIEXiZUFB2yimWKPYaqtoxUulF61Va+39st3u///2CZmZBELQTDIzIW5+r7b9bChfzsm5zORM7tyJFClSpEiR/OvZ1UZFSrGQLJxNLD4Kmu9qCaRkSRKYSNJkAJ4+D5JvsQI0NnCWNPDhWWCAG4CR8WyMqfvB8D1Kyjz4mgJPgwFk7qCWUkEgVjCgWCwOM1JRNBEnuANuyJhvuraV72ei/GxNKWJHXeQM+BwgQGG5f4gNX1ND+ZqC7Ag4Z8YKjKJKIs+Qz2DcEiGizNdPF6EJxQQj/2xDRI6qcTXiGQoz7AF1xFmIyDUrPoImLC4zdlGkTcNPtSWOhNhJCb7lUIfcX4v8NMXRTSeMVKHU3H/LfG26XYllgp8nYRgRcKzBl4zbsDjrHnC6KNo0vOn69xmqGYSpB/wIYa4ouo4zQ8s4cbdoeIvwcpljqEkahMPuCWtiJyGBC8BoyjMjkhM62LDo2oYhIOzPix1GLCbcx6kQEPZvJWwNSHGT4OowEOpmtInk2nAQ+lFEGBFGhP9hQoeGgY2CIhQTvDQtBkMo2NsFdhICIuSsiDAijAgdCOO8VAqIMF4f5KSFUkCEo32cVIhHhCEnHL3lXtpYmVaMSKMt8XtkgSNhYydexqtYGuDGyI/wOK60pkQNcFr35ka4ErenfcDnZuRFuFLqrGz4IHIinDMtmNNlIvJ4ZoEPYR0DZoTt8fHtDGKUBA77iHwIV8oI8NPJ2NjY3ZOZDPwzj+1uLoSDyIS5k7G7hsbeYsRbQjgHw0zm7RgmHPsIET">
    <link rel="stylesheet" href="styles.css">
</head>
<body>

<!-- Simple Form -->
<div class="form-container">
    <form action="#" method="post">
        <label for="search">Search Menu: </label>
        <input type="text" id="search" name="search" placeholder="Enter keywords">
        <button type="submit">Search</button>
    </form>
</div>

<!-- Menu Items -->
<section class="sec-1">
    <div class="dashboard-content">
        <% List<Menu> menuList = (List<Menu>) request.getAttribute("menuList");

        if (menuList != null && !menuList.isEmpty()) {
            for (Menu menuItem : menuList) {
        %>
        <div class="dashboard-card">
            <img class="card-image" src="<%=menuItem.getImagePath()%>" alt="<%=menuItem.getItemName()%>">
            <div class="card-details">
                <h4>
                    <%=menuItem.getItemName()%><span>Price: $ <%=menuItem.getPrice()%></span>
                </h4>
                <p><%=menuItem.getDescription()%></p>
                <span><p><%=menuItem.getIsAvailable()%></p></span>
                <p class="card-time">
                    <span class="fas fa-clock"></span>15-30 mins
                </p>

                <form action="cart" method="post">
                    <div class="input-group">
                        <input type="hidden" name="itemId" value="<%=menuItem.getMenuID()%>">
                    </div>
                    <div class="input-group">
                        Quantity: <input type="number" name="quantity" value="1" min="1" class="quantity-input">
                    </div>
                    <!-- add to cart button -->
                    <div class="input-group">
                        <input type="submit" value="Add to Cart" class="add-to-cart-btn">
                        <!-- HIdden field menu -->
                        <input type="hidden" name="action" value="add">
                    </div>
                </form>
            </div>
        </div>
        <% }
        } else { %>
        <p>No items found.</p>
        <% } %>
    </div>
</section>

</body>
</html>
