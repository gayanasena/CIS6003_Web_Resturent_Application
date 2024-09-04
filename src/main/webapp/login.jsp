<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login Page</title>
    <link href="https://fonts.googleapis.com/css2?family=Roboto:wght@400;700&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="CSS/login_css.css">
</head>
<body>
<div class="container">
    <div class="left-side">
        <img class="logo-img" src="Assets/logo_abc.png" alt="Logo">
        <form action="login" method="post">
            <input type="text" id="username" name="username" placeholder="Username" required>
            <input type="password" id="password" name="password" placeholder="Password" required>
            <button type="submit">Login</button>
            <hr>
            <button id="" type="submit" value="Login">Create new account</button>
        </form>
        <footer>
            <p>© Product of ABC Restaurants group 2024</p>
            <a href="https://www.abcrestaurantsgroup.com">www.abcrestaurantsgroup.com</a>
        </footer>
    </div>
    <div class="right-side">
    </div>
</div>
</body>
</html>

