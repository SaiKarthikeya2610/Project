<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="com.fod.model.User" %>
<%@ page import="com.fod.model.Restaurant" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Welcome to Food App</title>
    <style>
        body {
            font-family: 'Arial', sans-serif;
            background: url('FoodImages/background_image.jpg') no-repeat center center fixed;
            background-size: cover;
            margin: 0;
            padding: 0;
            color: #333;
        }
        .header {
            background: rgba(0, 0, 0, 0.7);
            color: white;
            padding: 15px;
            text-align: center;
            width: 100%;
            top: 0;
            left: 0;
            z-index: 1000;
        }
        .header a {
            color: white;
            margin: 0 15px;
            text-decoration: none;
            font-weight: bold;
        }
        .header a:hover {
            text-decoration: underline;
        }
        .container {
            width: 80%;
            margin: 100px auto 20px;
        }
        .restaurant-grid {
            display: grid;
            grid-template-columns: repeat(auto-fill, minmax(200px, 1fr));
            grid-gap: 20px;
        }
        .restaurant {
            background-color: rgba(255, 255, 255, 0.9);
            border: 1px solid #ddd;
            box-shadow: 0 2px 8px rgba(0, 0, 0, 0.15);
            border-radius: 8px;
            overflow: hidden;
            text-align: center;
            padding: 15px;
            transition: transform 0.3s ease, box-shadow 0.3s ease;
        }
        .restaurant:hover {
            transform: scale(1.05);
            box-shadow: 0 4px 12px rgba(0, 0, 0, 0.2);
        }
        .restaurant img {
            width: 100%;
            height: 150px;
            object-fit: cover;
            border-bottom: 1px solid #ddd;
        }
        .restaurant h2 {
            font-size: 18px;
            margin: 10px 0;
            color: #333;
        }
        .restaurant p {
            font-size: 14px;
            color: #666;
        }
        .restaurant a {
            display: inline-block;
            margin-top: 10px;
            padding: 10px 15px;
            background-color: #28a745;
            color: white;
            text-decoration: none;
            border-radius: 5px;
        }
        .restaurant a:hover {
            background-color: #218838;
        }
        .footer {
            text-align: center;
            padding: 20px;
            background: rgba(0, 0, 0, 0.7);
            color: white;
            position: relative;
            bottom: 0;
            width: 100%;
        }
    </style>
</head>
<body>
    <%@ include file="navbar.jsp" %> <!-- Include the navigation bar here -->

    <div class="container">
        <%
        List<Restaurant> restaurantsList = (List<Restaurant>) session.getAttribute("restaurantList");
        if (restaurantsList == null || restaurantsList.isEmpty()) {
            out.println("<p>No restaurants found.</p>");
        } else {
        %>
        <div class="restaurant-grid">
            <%
            for (Restaurant restaurant : restaurantsList) {
            %>
            <div class="restaurant">
                <img alt="Image of <%=restaurant.getRestautantName()%>" src="<%= request.getContextPath()%>/FoodImages/<%= restaurant.getImgpath()%>">
                <div>
                    <h2><%=restaurant.getRestautantName()%></h2>
                    <p>
                        Food Type: <%=restaurant.getFoodType()%><br>
                        Delivery Time: <%=restaurant.getDeliverytime()%> mins<br> 
                        Rating: <%=restaurant.getRatings()%>
                    </p>
                    <a href="menuServlet?restaurantId=<%=restaurant.getRestaurantId()%>">View Menu</a>
                </div>
            </div>
            <% 
            } 
            %>
        </div>
        <% 
        } 
        %>
    </div>

    <div class="footer">&copy; 2024 Food App</div>
</body>
</html>
