<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.fod.model.User" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>User Profile</title>
    <style>
        body {
            font-family: 'Arial', sans-serif;
            background: url('FoodImages/background_image.jpg') no-repeat center center fixed; /* Background image */
            background-size: cover;
            margin: 0;
            padding: 0;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
        }
        .container {
            background: rgba(255, 255, 255, 0.8); /* Slightly transparent white background */
            padding: 50px;
            border-radius: 12px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.2);
            width: 100%;
            max-width: 400px;
            text-align: center;
            border: 2px solid #ff7e5f; /* Border color */
        }
        h1 {
            margin-top: 0;
            color: #ff7e5f; /* Header color */
            font-size: 40px;
            font-weight: bold;
        }
        form {
            display: flex;
            flex-direction: column;
            gap: 25px;
        }
        label {
            font-size: 16px;
            text-align: left;
        }
        input[type="text"], input[type="password"] {
            padding: 8px;
            border: 4px solid #140ff48a; /* Input border color */
            border-radius: 10px;
            font-size: 16px;
            width: 100%;
            transition: border-color 0.3s ease;
        }
        input[type="text"]:focus, input[type="password"]:focus {
            border-color: #ff7e5f; /* Focus border color */
            outline: none;
        }
        input[type="submit"], .edit-mode {
            padding: 10px;
            border: 5px;
            border-radius: 10px;
            background: linear-gradient(135deg, #ff7e5f, #feb47b); /* Gradient background */
            color: white;
            font-size: 18px;
            cursor: pointer;
            transition: background 0.3s ease, transform 0.2s ease;
        }
        input[type="submit"]:hover, .edit-mode:hover {
            background: linear-gradient(135deg, #feb47b, #ff7e5f); /* Reversed gradient on hover */
            transform: scale(1.1); /* Slightly enlarge the button */
        }
        .edit-disabled {
            background-color: #eee;
            pointer-events: none;
            color: #999;
        }
    </style>
</head>
<body>

    <div class="container">
        <h1>User Profile</h1>
        <%
        Integer userId = Integer.parseInt(request.getParameter("userId"));
        User user = (User) session.getAttribute("user");

        if (user != null && user.getuserId()==(userId)) {

        %>
        <!-- Profile form with pre-filled user data -->
        <form id="profileForm" action="profileUpdateServlet" method="post">
            <label for="username">Username</label>
            <input type="text" id="username" name="username" value="<%=user.getuserName()%>" disabled>

            <label for="password">Password</label>
            <input type="password" id="password" name="password" value="<%=user.getPassword()%>" disabled>

            <label for="phoneNumber">Phone Number</label>
            <input type="text" id="phoneNumber" name="phoneNumber" value="<%=user.getPhoneNumber()%>" disabled>

            <label for="address">Address</label>
            <input type="text" id="address" name="address" value="<%=user.getAddress()%>" disabled>

            <input type="submit" id="updateBtn" value="Update Profile" class="edit-disabled" disabled>
            <input type="hidden" name="userId" value="<%=user.getuserId()%>">
        </form>

        <!-- Edit Mode Button -->
        <button class="edit-mode" id="editBtn" onclick="enableEditing()">Edit Profile</button>

        <%
        } else {
            out.println("<p class='message'>User not logged in. Please <a href='login.jsp'>login</a> first.</p>");
        }
        %>
    </div>

    <script>
        function enableEditing() {
            // Enable all form inputs for editing
            document.getElementById('username').disabled = false;
            document.getElementById('password').disabled = false;
            document.getElementById('phoneNumber').disabled = false;
            document.getElementById('address').disabled = false;
            // Enable the Update button
            document.getElementById('updateBtn').disabled = false;
            document.getElementById('updateBtn').classList.remove('edit-disabled');
            // Hide the Edit button
            document.getElementById('editBtn').style.display = 'none';
        }
    </script>

</body>
</html>
