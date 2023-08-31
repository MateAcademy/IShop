<%--
  Created by IntelliJ IDEA.
  User: Sergey
  Date: 31.08.2023
  Time: 7:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add user</title>
</head>
<body>

<center>
    <h2> Add new User to DB:</h2>
    <br/>
    <form action="/users/add" method="post">
        <label for="email">Enter email: </label>
        <input type="email" id="email" name="email" value="*******"/>
        <br/>

        <label for="password">Enter password: </label>
        <input type="password" id="password" name="password" value="*******"/>
        <br/>
        <input type="submit" value="Enter!"/>
    </form>
</center>


</body>
</html>
