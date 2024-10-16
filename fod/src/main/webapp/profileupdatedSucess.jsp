<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Profile Updated Successfully</title>
    <style>
        body {
            display: flex;
            background: url('FoodImages/background_image.jpg') no-repeat center center fixed;
            justify-content: center;
            align-items: center;
            height: 100vh;
            background-color: #f4f4f4;
            font-family: Arial, sans-serif;
            text-align: center;
        }
        .container {
            padding: 20px;
            background-color: white;
            border-radius: 10px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }
        .thumbsup {
            font-size: 50px;
            color: green;
        }
        .message {
            font-size: 20px;
            margin-top: 20px;
        }
    </style>
    <!-- JavaScript for automatic redirection after 3 seconds -->
    <script>
        setTimeout(function(){
            window.location.href = 'homeServlet'; // Redirect to homeServlet after 3 seconds
        }, 3000);
    </script>
</head>
<body>
    <div class="container">
        <!-- Thumbs-up emoji or icon -->
        <div class="thumbsup">👍</div>
        <!-- Success message -->
        <div class="message">Your profile has been updated successfully!</div>
        <!-- Redirect notice -->
        <div class="redirect">Redirecting to home page...</div>
    </div>
</body>
</html>
