<%@ page import="java.util.Map"%>
<%@ page import="com.fod.model.cart"%>
<%@ page import="com.fod.model.cartItem"%>
<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Billing Items</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background: url('<%= request.getContextPath() %>/FoodImages/background_image.jpg') no-repeat center center fixed;
            background-size: cover;
            margin: 0;
            padding: 0;
        }
        
        h1 {
            text-align: center;
            color: #ffffff;
            padding: 20px;
            background-color: rgba(0, 0, 0, 0.7); /* Dark background for readability */
            margin-bottom: 20px;
        }

        .container {
            width: 80%;
            margin: 20px auto;
            background-color: rgba(255, 255, 255, 0.9); /* Slight transparency */
            padding: 20px;
            box-shadow: 0 0 20px rgba(0, 0, 0, 0.1);
            border-radius: 10px;
        }

        table {
            width: 100%;
            border-collapse: collapse;
            margin-bottom: 20px;
            background-color: rgba(255, 255, 255, 0.8);
        }

        table th, table td {
            padding: 15px;
            border: 1px solid #ddd;
            text-align: center;
        }

        table th {
            background-color: #007bff;
            color: white;
        }

        table td {
            background-color: #f8f9fa;
        }

        .total {
            text-align: right;
            font-size: 1.5em;
            font-weight: bold;
            margin-top: 20px;
            color: #333;
        }

        .form-container {
            display: flex;
            flex-direction: column;
            align-items: center;
            justify-content: center;
            margin-top: 20px;
        }

        input[type="text"], select, input[type="number"], input[type="date"] {
            width: 60%;
            padding: 12px;
            margin-bottom: 15px;
            border: 1px solid #ccc;
            border-radius: 5px;
            box-sizing: border-box;
            font-size: 1.1em;
        }

        input[type="submit"] {
            width: 60%;
            background-color: #28a745;
            color: white;
            padding: 15px;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            font-size: 1.2em;
            text-align: center;
            transition: background-color 0.3s;
        }

        input[type="submit"]:hover {
            background-color: #218838;
        }

        label {
            width: 60%;
            font-size: 1.1em;
            font-weight: bold;
            margin-bottom: 10px;
            text-align: left;
        }

        p {
            text-align: center;
            font-size: 1.2em;
            color: #555;
        }

        img {
            max-width: 100px;
            height: auto;
            border-radius: 5px;
        }

        .credit-details {
            display: none;
            width: 60%;
        }

    </style>
    <script>
        function togglePaymentDetails() {
            var paymentMode = document.getElementById("paymentMode").value;
            var creditDetails = document.getElementById("creditDetails");

            if (paymentMode === "creditDebit") {
                creditDetails.style.display = "block"; // Show credit card details
            } else {
                creditDetails.style.display = "none"; // Hide credit card details
            }
        }
    </script>
</head>
<body>
    <h1>Billing Items</h1>
    <form action="placeOrderServlet" method="post">
        <div class="container">
            <%
            cart cart = (cart) session.getAttribute("cart");
            if (cart != null && cart.getItems() != null && !cart.getItems().isEmpty()) {
                Map<Integer,cartItem> cartItems = cart.getItems();
                float totalAmount = 0.0f;
            %>
            <table>
                <tr>
                    <th>Image</th>
                    <th>Item Name</th>
                    <th>Quantity</th>
                    <th>Price</th>
                    <th>Subtotal</th>
                </tr>
                <%
                for (cartItem item : cartItems.values()) {
                    float subtotal = item.getPrice() * item.getQunatity();
                    totalAmount += subtotal;
                %>
                <tr>
                    <td><img src="<%= request.getContextPath() %>/FoodImages/<%=item.getImgpath() %>" alt="<%=item.getItemName() %>"></td>
                    <td><%= item.getItemName() %></td>
                    <td><%= item.getQunatity() %></td>
                    <td>₹<%= item.getPrice() %></td>
                    <td>₹<%= subtotal %></td>
                </tr>
                <%
                }
                %>
            </table>
            <div class="total">
                <h2>Total: ₹<%= totalAmount %></h2>
            </div>

            <!-- Add a hidden input field to send totalAmount to the servlet -->
            <input type="hidden" name="totalAmount" value="<%= totalAmount %>">
            
            <%
            } else {
            %>
            <p>Your cart is empty.</p>
            <%
            }
            %>

            <!-- Form Section -->
            <div class="form-container">
                <label for="address">Address:</label>
                <input type="text" id="address" name="address" required>

                <label for="paymentMode">Payment Mode:</label>
                <select id="paymentMode" name="Payment" onchange="togglePaymentDetails()">
                    <option value="cash">Cash</option>
                    <option value="creditDebit">Credit or Debit</option>
                    <option value="upi">UPI</option>
                </select>

                <!-- Credit/Debit Card Details -->
                <div id="creditDetails" class="credit-details">
                    <label for="cardNumber">Card Number:</label>
                    <input type="number" id="cardNumber" name="cardNumber" maxlength="12" placeholder="Enter 12-digit card number" required>

                    <label for="cvv">CVV:</label>
                    <input type="number" id="cvv" name="cvv" maxlength="3" placeholder="Enter CVV" required>

                    <label for="expiryDate">Expiry Date:</label>
                    <input type="date" id="expiryDate" name="expiryDate" required>
                </div>

                <input type="submit" value="Place Order">
            </div>
        </div>
    </form>
</body>
</html>
