<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ page import="com.fod.model.Menu"%>
<%@ page import="com.fod.model.Restaurant"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Menu - Food App</title>
<style>
body {
	font-family: Arial, sans-serif;
	margin: 0;
	padding: 0;
	background:	url('<%= request.getContextPath() %>/FoodImages/cartbackground_image.jpg') no-repeat center center fixed;
	background-size: cover;
	color: #333;
}

.container {
	width: 80%;
	margin: 20px auto;
	/* Semi-transparent background */
	border-radius: 8px;
	box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
	padding: 20px;
}

h1, h2 {
	text-align: center;
	color: #ffffff;
	margin-top: 20px;
}

.restaurant-info {
	text-align: center;
	margin-bottom: 20px;
}

.menu-item {
	display: flex;
	align-items: center;
	padding: 20px;
	margin-bottom: 15px;
	background-color: #fff;
	border-radius: 8px;
	box-shadow: 0 0 5px rgba(0, 0, 0, 0.1);
	justify-content: space-between; /* Distributes space between items */
}

.menu-item img {
	width: 150px;
	height: 100px;
	object-fit: cover;
	border-radius: 8px;
	margin-right: 15px;
}

.menu-item div {
	flex-grow: 1; /* Takes up remaining space */
}

.menu-item h2 {
	margin: 0;
	font-size: 1.5em;
	color: #333;
}

.menu-item p {
	margin: 5px 0;
	font-size: 1em;
	color: #666;
}

.menu-item .price {
	font-weight: bold;
	color: #28a745;
}

.menu-item .availability {
	color: #dc3545;
}

.menu-item form {
	display: flex;
	flex-direction: column;
	align-items: flex-end; /* Aligns the items to the right */
	margin-top: 10px;
}

.form-group {
	display: flex;
	align-items: center; /* Aligns items vertically in the center */
	margin-bottom: 10px;
}

.form-group input[type="number"] {
	width: 60px;
	padding: 5px;
	border: 2px solid #274af5;
	border-radius: 4px;
	margin-right: 10px;
}

.form-group label {
	margin-right: 5px;
	font-size: 16px;
}

.menu-item input[type="submit"] {
	padding: 10px 15px;
	border: none;
	border-radius: 4px;
	background-color: #28a745;
	color: white;
	font-size: 16px;
	cursor: pointer;
}

.menu-item input[type="submit"]:hover {
	background-color: #218838;
}
</style>
</head>
<body>

	<h1>Menu</h1>

	<div class="container">
		<%
            // Assuming restaurantName is passed in session or request
           
            Restaurant restaurant =(Restaurant) session.getAttribute("restaurantById");
            List<Menu> menuList = (List<Menu>) session.getAttribute("MenuDAO1");

            if (menuList != null && !menuList.isEmpty()) {
                // Get the total number of items
                int totalItems = menuList.size();
        %>

		<!-- Display the restaurant name and number of items -->
		<div class="restaurant-info">
			<h2><%= restaurant.getRestautantName()%></h2>
			<h2>
				Total Items Available:
				<%= totalItems %></h2>
		</div>

		<!-- Menu items display -->
		<%
                for (Menu menu : menuList) {
        %>
		<div class="menu-item">
			<img
				src="<%= request.getContextPath() %>/FoodImages/<%= menu.getImgpath() %>"
				alt="<%= menu.getMenuName() %>">
			<div>
				<h2><%= menu.getMenuName() %></h2>
				<p class="price">
					Price: ₹<%= menu.getPrice() %></p>
				<p>
					Description:
					<%= menu.getDescription() %></p>
				<p class="availability">
					Availability:
					<%= menu.isAvailable() ? "Available" : "Out of Stock" %></p>
			</div>
			<form action="cartServelet" method="post">
				<input type="hidden" name="itemId" value="<%= menu.getMenuId() %>">
				<div class="form-group">
					<label for="quantity<%= menu.getMenuId() %>">Quantity:</label> <input
						id="quantity<%= menu.getMenuId() %>" type="number" name="quantity"
						value="1" min="1">
				</div>
				<input type="submit" value="Add to Cart"> <input
					type="hidden" name="action" value="add">
			</form>
		</div>
		<%
                }
            } else {
        %>
		<p>No menu items found for this restaurant.</p>
		<%
            }
        %>
	</div>
</body>
</html>
