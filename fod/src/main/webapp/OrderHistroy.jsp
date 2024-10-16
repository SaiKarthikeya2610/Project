<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="com.fod.model.orderHistory" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Order History</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
            background-image: url('FoodImages/background_image.jpg'); /* Add your background image here */
            background-size: cover;
            background-position: center;
            background-attachment: fixed;
            background-repeat: no-repeat;
        }
        .container {
            width: 1000px;
            margin: 50px auto;
            padding: 20px;
            background-color: rgba(255, 255, 255, 0.8); /* Add transparency to background */
            box-shadow: 0 0 15px rgba(0, 0, 0, 0.3);
            border-radius: 10px;
        }
        table {
            width: 100%;
            border-collapse: collapse;
            margin-top: 20px;
        }
        table, th, td {
            border: 1px solid #ddd;
        }
        th, td {
            padding: 12px 15px;
            text-align: left;
        }
        th {
            background-color: #4CAF50;
            color: white;
        }
        tr:nth-child(even) {
            background-color: #f2f2f2;
        }
        tr:hover {
            background-color: #eaeaea;
        }
        h1 {
            text-align: center;
            color: #333;
            font-size: 2em;
            margin-bottom: 20px;
        }
        .action-button {
            background-color: #4CAF50;
            color: white;
            border: none;
            padding: 10px 15px;
            text-align: center;
            text-decoration: none;
            display: inline-block;
            font-size: 14px;
            margin: 4px 2px;
            cursor: pointer;
            border-radius: 5px;
        }
        .action-button:hover {
            background-color: #45a049;
        }
        .no-orders {
            text-align: center;
            color: white;
            font-size: 1.5em;
            font-weight: bold;
            margin-top: 50px;
        }
    </style>
</head>
<body>
    <div class="container">
        <h1>Order History</h1>

        <%
            // Retrieve the order history from the session
            List<orderHistory> allOrdersTableByUserId = (List<orderHistory>) session.getAttribute("allOrderHistoryonUserID");
            

            if (allOrdersTableByUserId != null && !allOrdersTableByUserId.isEmpty()) {
        %>
            <table>
                <thead>
                    <tr>
                        <th>Order History ID</th>
                        <th>Order ID</th>
                        <th>User ID</th>
                        <th>Order Date</th>
                        <th>Total Amount</th>
                        <th>Status</th>
                        <th>Action</th>
                    </tr>
                </thead>
                <tbody>
                    <%
                        for (orderHistory order : allOrdersTableByUserId) {
                    %>
                    <tr>
                        <td><%= order.getOrderhistoryId() %></td>
                        <td><%= order.getOrderId() %></td>
                        <td><%= order.getUserId() %></td>
                        <td><%= order.getOrderDate() %></td>
                        <td>₹<%= order.getTotalAmount() %></td>
                        <td><%= order.getStatus() %></td>
                        <td>
                            <form action="orderItemTableServlet" method="post">
                                <input type="hidden" name="orderId" value="<%= order.getOrderId() %>">
                                <input type="submit" value="View Items" class="action-button">
                            </form>
                        </td>
                    </tr>
                    <%
                        }
                    %>
                </tbody>
            </table>
        <%
            } else {
        %>
            <p class="no-orders">No orders found.</p>
        <%
            }
        %>

    </div>
</body>
</html>
