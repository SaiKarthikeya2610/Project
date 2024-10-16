<%@ page import="java.util.Map"%>
<%@ page import="com.fod.model.cart"%>
<%@ page import="com.fod.model.cartItem"%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<!DOCTYPE html>
<html>
<head>
<title>Shopping Cart</title>
<style>
body {
    font-family: Arial, sans-serif;
    background-image: url('FoodImages/cartbackground_image.jpg'); /* Add background image */
    background-size: cover; /* Ensure the image covers the entire viewport */
    background-position: center; /* Center the background image */
    background-attachment: fixed; /* Fix the image during scroll */
    background-repeat: no-repeat; /* Avoid repeating the background */
    margin: 0;
    padding: 0;
}

h1, h2 {
    color: #333;
    text-align: center;
}

table {
    width: 80%;
    margin: 20px auto;
    border-collapse: collapse;
    background-color: #fff;
    box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
}

th, td {
    padding: 10px;
    text-align: center;
    border-bottom: 1px solid #ddd;
}

th {
    background-color: #f2f2f2;
}

tr:hover {
    background-color: #f1f1f1;
}

td:nth-child(4), td:nth-child(5), td:nth-child(6) {
    text-align: right;
}

.actions {
    display: flex;
    justify-content: space-between;
    gap: 10px;
}

.actions form {
    display: inline-block;
    margin: 0;
}

input[type="submit"] {
    background-color: #4CAF50;
    color: white;
    border: none;
    padding: 5px 10px;
    cursor: pointer;
}

input[type="submit"]:hover {
    background-color: #45a049;
}

.container {
   
    margin: 0 auto;
    padding: 20px;
    
    box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
    border-radius: 8px; /* Rounded corners for the container */
}

.total {
    text-align: right;
    font-size: 1.2em;
    font-weight: bold;
}

.ProceedPay {
    display: block;
    width: 100%;
    text-align: center;
    margin-top: 20px;
}

.ProceedPay input[type="submit"] {
    width: auto;
    padding: 10px 20px;
    font-size: 1em;
    text-align: center;
}
</style>
</head>
<body>
    <h1>Your Cart</h1>
    <div class="container">
        <%
        cart cart = (cart) session.getAttribute("cart");

        if (cart != null && cart.getItems() != null && !cart.getItems().isEmpty()) {
            int restaurantId = cart.getItems().values().iterator().next().getResturantId(); // Ensure the restaurantId is available
            Map<Integer,cartItem> cartItems = cart.getItems();
            float totalAmount = 0;
        %>
        <table>
            <tr>
                <th>Image Food</th>
                <th>Item Name</th>
                <th>Availability</th>
                <th>Quantity</th>
                <th>Price</th>
                <th>Subtotal</th>
                <th>Actions</th>
            </tr>
            <%
            for (cartItem item : cartItems.values()) {
                float subtotal = item.getPrice() * item.getQunatity();
                totalAmount += subtotal;
            %>
            <tr>
                <td><img
                    src="<%=request.getContextPath()%>/FoodImages/<%=item.getImgpath()%>"
                    alt="<%=item.getItemName()%>" style="width: 100px; height: auto;"></td>
                <td><%=item.getItemName()%></td>

                <td><%=item.isAvaliable() %></td>
                <td><%=item.getQunatity()%></td>
                <td>₹<%=item.getPrice()%></td>
                <td>₹<%=subtotal%></td>
                <td>
                    <div class="actions">
                        <!-- Update Button -->
                        <form action="cartServelet" method="post">
                            <input type="hidden" name="action" value="update"> 
                            <input type="hidden" name="itemId" value="<%=item.getItemid()%>">
                            <input type="number" name="quantity" value="<%=item.getQunatity()%>" min="1"> 
                            <input type="submit" value="Update">
                        </form>

                        <!-- Add More Items Button -->
                        <form action="menuServlet" method="get">
                            <input type="hidden" name="restaurantId" value="<%=restaurantId%>"> 
                            <input type="submit" value="Add More Items">
                        </form>

                        <!-- Remove Button -->
                        <form action="cartServelet" method="post">
                            <input type="hidden" name="action" value="erase"> 
                            <input type="hidden" name="itemId" value="<%=item.getItemid()%>">
                            <input type="submit" value="Remove">
                        </form>
                    </div>
                </td>
            </tr>
            <%
            }
            %>
        </table>
        <div class="total">
            <h2>
                Total: ₹<%=totalAmount%></h2>
        </div>
        <div class="ProceedPay">
            <form action="checkout.jsp">
                <input type="submit" value="Proceed to Pay">
            </form>
        </div>

        <%
        } else {
        %>
        <p>Your cart is empty.</p>
        <%
        }
        %>
    </div>
</body>
</html>
