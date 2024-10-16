<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Food Sign In Form</title>
    <style>
        body {
            font-family: 'Arial', sans-serif;
            background: url('FoodImages/background_image.jpg') no-repeat center center fixed; /* Background image */
            background-size: cover; /* Ensures the image covers the entire viewport */
            background-blur: 5px; /* Optional: Add a blur effect to the background */
            margin: 0;
            padding: 0;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
        }
        .login-container {
            background: rgba(255, 255, 255, 0.8); /* Slightly transparent white background */
            padding: 50px;
            border-radius: 12px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.2);
            width: 100%;
            max-width: 400px;
            text-align: center;
            border: 2px solid #ff7e5f; /* Border color */
        }
        .login-container h2 {
            margin-top: 0;
            color: #ff7e5f; /* Header color */
            font-size: 40px;
            font-weight: bold;
        }
        .login-container form {
            display: flex;
            flex-direction: column;
            gap: 25px;
        }
        .login-container input[type="text"],
        .login-container input[type="password"] {
            padding: 8px;
            border: 4px solid #140ff48a; /* Input border color */
            border-radius: 10px;
            font-size: 16px;
            width: 100%;
            transition: border-color 0.3s ease;
        }
        .login-container input[type="text"]:focus,
        .login-container input[type="password"]:focus {
            border-color: #ff7e5f; /* Focus border color */
            outline: none;
        }
        .login-container input[type="submit"] {
            padding: 10px;
            border: 5px;
            border-radius: 10px;
            background: linear-gradient(135deg, #ff7e5f, #feb47b); /* Gradient background */
            color: white;
            font-size: 18px;
            cursor: pointer;
            transition: background 0.3s ease, transform 0.2s ease;
        }
        .login-container input[type="submit"]:hover {
            background: linear-gradient(135deg, #feb47b, #ff7e5f); /* Reversed gradient on hover */
            transform: scale(1.250); /* Slightly enlarge the button */
        }
        .login-container a {
            display: block;
            margin-top: 15px;
            color: #ff7e5f;
            text-decoration: none;
            font-size: 14px;
        }
        .login-container a:hover {
            text-decoration: underline;
        }
    </style>
</head>
<body>
    <div class="login-container">
        <h2>Sign In Here</h2>
        <form action="loginServlet" method="post">
            <input type="text" name="email" placeholder="Email" required>
            <input type="password" name="password" placeholder="Password" required>
            <input type="submit" value="SIGN IN">
            <a href="forgotPassword.jsp">Forgot Password</a>
            <a href="register.jsp">New User? Register Here</a>
        </form>
    </div>
</body>
</html>