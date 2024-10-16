<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>About Us</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background: url('FoodImages/background_image.jpg') no-repeat center center fixed;
            background-size: cover;
            margin: 0;
            padding: 0;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
        }
        .about-container {
            background: rgba(255, 255, 255, 0.9);
            padding: 50px;
            border-radius: 10px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.2);
            width: 100%;
            max-width: 800px;
            text-align: center;
            border: 2px solid #4CAF50;
        }
        h1 {
            color: #4CAF50;
            font-size: 36px;
            margin-bottom: 20px;
        }
        p {
            font-size: 18px;
            line-height: 1.6;
            color: #333;
        }
        .details {
            margin-top: 30px;
        }
        .details h2 {
            font-size: 24px;
            margin-bottom: 15px;
            color: #4CAF50;
        }
        .details p {
            font-size: 16px;
            color: #555;
        }
        .social-icons {
            margin-top: 20px;
        }
        .social-icons a {
            margin: 0 10px;
            text-decoration: none;
        }
        .social-icons img {
            width: 40px;
            height: 40px;
        }
    </style>
</head>
<body>
    <div class="about-container">
        <h1>About This Project</h1>
        <p>
            This project is a food ordering system designed to simplify the way users can browse, select, 
            and order food online from various restaurants. It integrates several key functionalities, 
            including user authentication, menu browsing, cart management, order history tracking, and more.
        </p>
        <p>
            Users can seamlessly explore available food items, customize their order, and proceed to checkout.
            The platform is designed to provide a user-friendly experience, ensuring secure and fast transactions.
        </p>
        
        <div class="details">
            <h2>Contact Information</h2>
            <p><strong>Name:</strong> Sai Karthikeya Rachamalla</p>
            <p><strong>Contact:</strong> +91 6303864539</p>
            <p><strong>Email:</strong> <a href="mailto:saikarthikeyarachamalla@gmail.com">saikarthikeyarachamalla@gmail.com</a></p>
        </div>

        <div class="social-icons">
            <a href="https://github.com/SaiKarthikeya2610" target="_blank">
                <img src="https://upload.wikimedia.org/wikipedia/commons/9/91/Octicons-mark-github.svg" alt="GitHub">
            </a>
            <a href="https://www.linkedin.com/in/sai-karthikeya-rachamalla-4445522ab/" target="_blank">
                <img src="https://upload.wikimedia.org/wikipedia/commons/thumb/c/ca/LinkedIn_logo_initials.png/768px-LinkedIn_logo_initials.png" alt="LinkedIn">
            </a>
        </div>
    </div>
</body>
</html>
