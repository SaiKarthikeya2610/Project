<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Food Sign Up Form</title>
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
        .signup-container {
            background: rgba(255, 255, 255, 0.8); /* Slightly transparent white background */
            padding: 50px;
            border-radius: 12px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.2);
            width: 100%;
            max-width: 400px;
            text-align: center;
            border: 2px solid #ff7e5f; /* Border color */
        }
        .signup-container h2 {
            margin-top: 0;
            color: #ff7e5f; /* Header color */
            font-size: 40px;
            font-weight: bold;
        }
        .signup-container form {
            display: flex;
            flex-direction: column;
            gap: 25px;
        }
        .signup-container input[type="text"],
        .signup-container input[type="email"],
        .signup-container input[type="password"],
        .signup-container input[type="tel"] {
            padding: 8px;
            border: 4px solid #140ff48a; /* Input border color */
            border-radius: 10px;
            font-size: 16px;
            width: 100%;
            transition: border-color 0.3s ease;
        }
        .signup-container input[type="text"]:focus,
        .signup-container input[type="email"]:focus,
        .signup-container input[type="password"]:focus,
        .signup-container input[type="tel"]:focus {
            border-color: #ff7e5f; /* Focus border color */
            outline: none;
        }
        .signup-container input[type="submit"] {
            padding: 10px;
            border: 5px;
            border-radius: 10px;
            background: linear-gradient(135deg, #ff7e5f, #feb47b); /* Gradient background */
            color: white;
            font-size: 18px;
            cursor: pointer;
            transition: background 0.3s ease, transform 0.2s ease;
        }
        .signup-container input[type="submit"]:hover {
            background: linear-gradient(135deg, #feb47b, #ff7e5f); /* Reversed gradient on hover */
            transform: scale(1.250); /* Slightly enlarge the button */
        }
        .signup-container p {
            margin-top: 15px;
            font-size: 14px;
        }
        .signup-container p a {
            color: #ff7e5f;
            text-decoration: none;
        }
        .signup-container p a:hover {
            text-decoration: underline;
        }
    </style>
</head>
<body>
    <div class="signup-container">
        <h2>Sign Up Here</h2>
        <form action="registerServlet" method="post">
            <input type="text" name="username" placeholder="Username" required>
            <input type="email" name="email" placeholder="Email" required>
            <input type="password" name="password" placeholder="Password" required>
            <input type="text" name="phoneNumber" placeholder="PhoneNumber" required>
            <input type="text" name="address" placeholder="Address" required>
            <input type="submit" value="REGISTER">
            <p>Already have an account? <a href="login.jsp">Sign In</a></p>
        </form>
    </div>
</body>
</html>
