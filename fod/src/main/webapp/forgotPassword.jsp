<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Reset Password</title>
    <style>
        body {
            font-family: 'Arial', sans-serif;
            background: url('FoodImages/background_image.jpg') no-repeat center center fixed; /* Background image */
            background-size: cover; /* Ensures the image covers the entire viewport */
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
        .container h2 {
            margin-top: 0;
            color: #ff7e5f; /* Header color */
            font-size: 40px;
            font-weight: bold;
        }
        .container form {
            display: flex;
            flex-direction: column;
            gap: 25px;
        }
        .container input[type="text"],
        .container input[type="password"] {
            padding: 8px;
            border: 4px solid #140ff48a; /* Input border color */
            border-radius: 10px;
            font-size: 16px;
            width: 100%;
            transition: border-color 0.3s ease;
        }
        .container input[type="text"]:focus,
        .container input[type="password"]:focus {
            border-color: #ff7e5f; /* Focus border color */
            outline: none;
        }
        .container input[type="submit"] {
            padding: 10px;
            border-radius: 10px;
            background: linear-gradient(135deg, #ff7e5f, #feb47b); /* Gradient background */
            color: white;
            font-size: 18px;
            cursor: pointer;
            transition: background 0.3s ease, transform 0.2s ease;
        }
        .container input[type="submit"]:hover {
            background: linear-gradient(135deg, #feb47b, #ff7e5f); /* Reversed gradient on hover */
            transform: scale(1.250); /* Slightly enlarge the button */
        }
        .container a {
            display: block;
            margin-top: 15px;
            color: #ff7e5f;
            text-decoration: none;
            font-size: 14px;
        }
        .container a:hover {
            text-decoration: underline;
        }
    </style>
</head>
<body>

    <div class="container">
        <h2>Reset Password</h2>
        <form action="forgetPasswordServlet" method="post">
            <input type="text" name="email" placeholder="Email" required>
            <input type="password" name="password" placeholder="New Password" required>
            <input type="submit" value="Reset Password">
            <a href="login.jsp">Back to Login</a>
        </form>
    </div>

</body>
</html>
