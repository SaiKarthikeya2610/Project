<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="refresh" content="5;url=homeServlet">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Order Confirmation</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-image: url('FoodImages/background_image.jpg');
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            background-color: #f4f4f4;
        }
        .confirmation-box {
            background-color: #fff;
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            text-align: center;
        }
        .tick-mark {
            font-size: 50px;
            color: green;
        }
        .message {
            font-size: 24px;
            color: #333;
            margin: 20px 0;
        }
        .sub-message {
            color: gray;
            margin-top: 10px;
        }
    </style>
</head>
<body>

    <div class="confirmation-box">
        <div class="tick-mark">&#10004;</div>
        <div class="message">Order Confirmed!</div>
        <p>Your order has been successfully placed.</p>
        <div class="sub-message">
            You will be redirected to the home page shortly.
        </div>
    </div>

</body>
</html>
