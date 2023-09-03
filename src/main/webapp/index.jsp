<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>IShop</title>
    <link rel="stylesheet" href="frontend/styles/style.css">
    <meta name="description" content="Лучшая выпечка в городе">
</head>
<body bgcolor="#ffe4c4">

<center>
    <div class="title1"> </div>
    <div class="title2"> </div>
    <% String error = (String) request.getAttribute("error");
        if (error != null) {
            out.println(error);
        }
    %>

    <h2> Enter your login and password!</h2>
    <br/>
    <form action="/login" method="post">
        <label for="email">Enter email: </label>
        <input type="email" id="email" name="email" value="*******"/>
        <br/>

        <label for="password">Enter password: </label>
        <input type="password" id="password" name="password" value="*******"/>
        <br/>
        <input type="submit" value="Enter!"/>
    </form>
</center>

<br/>
<br/>
<center>
    <h2> You can register if you don't have account!</h2>
    <a href="/register">Register</a>
</center>

<br/>
<br/>

<center>
    <h2> If you forgot password enter your email!</h2>
    <form action="/forgotPassword" method="post">
        <label for="email2">Enter email:</label>
        <input type="email" id="email2" name="email">
        <br/>
        <input type="submit" value="Enter!">
    </form>
    <a href="/register">Register</a>
</center>

</body>
</html>
