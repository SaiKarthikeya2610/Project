<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Password Updated Successfully</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background: url('FoodImages/background_image.jpg') no-repeat center center fixed;
            text-align: center;
            margin-top: 50px;
        }
        .container {
            display: inline-block;
            padding: 20px;
            border: 1px solid #d4edda;
            border-radius: 5px;
            background-color: #d4edda;
            color: #155724;
        }
        .tick-icon {
            font-size: 48px;
            color: #155724;
        }
        .message {
            font-size: 24px;
            margin-top: 10px;
        }
        .redirecting {
            font-size: 18px;
            margin-top: 20px;
        }
    </style>
    <meta http-equiv="refresh" content="3;url=login.jsp">
</head>
<body>
    <div class="container">
        <div class="tick-icon">&#10004;</div>
        <div class="message">Password updated successfully!</div>
        <div class="redirecting">Now, please <a href="login.jsp">login</a>.</div>
    </div>
</body>
</html>
