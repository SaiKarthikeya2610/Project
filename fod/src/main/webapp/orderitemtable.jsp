<%@page import="com.fod.model.Menu"%>
<%@page import="com.fod.DAO.menuDAO"%>
<%@page import="com.fod.DAOImpl.menuDAOImpl"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="com.fod.model.orderItemTable" %>
<html>
<head>
    <title>Order Item Table</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
            background: url('<%= request.getContextPath() %>/FoodImages/background_image.jpg') no-repeat center center fixed;
            background-size: cover;
            height: 100vh;
            display: flex;
            justify-content: center;
            align-items: center;
        }        
        .container {
            background-color: rgba(255, 255, 255, 0.9);
            padding: 30px;
            border-radius: 10px;
            box-shadow: 0 4px 12px rgba(0, 0, 0, 0.3);
            width: 70%;
            max-width: 1000px;
            text-align: center;
        }

        h1 {
            color: #333;
            margin-bottom: 20px;
        }

        table {
            width: 100%;
            border-collapse: collapse;
            margin-bottom: 20px;
        }

        table, th, td {
            border: 1px solid #ccc;
        }

        th, td {
            padding: 12px;
            text-align: left;
        }

        th {
            background-color: #f8f8f8;
        }

        td {
            background-color: #fff;
        }

        img {
            width: 80px;
            height: auto;
            border-radius: 8px;
        }

        .no-data {
            text-align: center;
            padding: 20px;
            font-size: 18px;
            color: #888;
        }

        .back-button {
            display: inline-block;
            margin-top: 20px;
            padding: 10px 20px;
            background-color: #28a745;
            color: white;
            text-decoration: none;
            font-size: 16px;
            border-radius: 5px;
            transition: background-color 0.3s ease;
        }

        .back-button:hover {
            background-color: #218838;
        }
    </style>
</head>
<body>
    <div class="container">
        <h1>Order Item Details</h1>

        <%
            // Retrieve the list of orderItemTable objects from the session
            List<orderItemTable> orderItemTableList = (List<orderItemTable>) session.getAttribute("allOrderItemsByOrderId");

            if (orderItemTableList != null && !orderItemTableList.isEmpty()) {
        %>
            <table>
                <tr>
                    <th>Order Item Table ID</th>
                    <th>Order ID</th>
                    <th>Menu Name</th>
                    <th>Price</th>
                    <th>Quantity</th>
                    <th>Subtotal</th>
                    <th>Image</th>
                </tr>
                <%
                    for (orderItemTable orderItem : orderItemTableList) {
                        Integer menuId = orderItem.getMenuId();
                        menuDAO menuDAO = new menuDAOImpl();
                        Menu menu = menuDAO.getMenuById(menuId);

                        if (menu != null) {
                            float subtotal = orderItem.getQuanitiy() * menu.getPrice();
                %>
                <tr>
                    <td><%= orderItem.getOrderItemId() %></td>
                    <td><%= orderItem.getOrderId() %></td>
                    <td><%= menu.getMenuName() %></td>
                    <td>₹<%= menu.getPrice() %></td>
                    <td><%= orderItem.getQuanitiy() %></td>
                    <td>₹<%= subtotal %></td>
                    <td><img src="<%= request.getContextPath() %>/FoodImages/<%= menu.getImgpath() %>" alt="<%= menu.getMenuName() %>"></td>
                </tr>
                <%
                        }
                    }
                %>
            </table>
        <%
            } else {
        %>
            <p class="no-data">No order item details found for this order.</p>
        <%
            }
        %>

        <!-- Button to go back to the homepage -->
        <a href="<%= request.getContextPath() %>/homepage.jsp" class="back-button">Go to Homepage</a>
    </div>
</body>
</html>
