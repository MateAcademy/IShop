<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 8/31/23
  Time: 11:24 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>
<html>
<head>
    <title>Edit user</title>
</head>
<body>


<form action="/users/update" method="post" >
    <table>
        <tr>
            <input name="id" type="hidden" value="${user.userId}"/>
        </tr>
        <tr>
            <td>Edit email:</td>
            <td><input type="text" name="email" value="${user.email}" /></td>
        </tr>
        <tr>
            <td>Edit password:</td>
            <td><input type="text" name="passwordNotEncoded"   value="${user.passwordNotEncoded}"  /></td>
        </tr>
    </table>
    <input type="submit" value="Update user data" />
</form>


<%--<center>--%>
<%--    <h2> Edit User:</h2>--%>
<%--    <br/>--%>
<%--    <form action="/users/edite" method="post" user="${user}">--%>
<%--        <label for="email">Edit email: </label>--%>
<%--        <input type="email" id="email" name="email" value=${user.email}/>--%>
<%--        <br>--%>
<%--        <br>--%>

<%--        <label for="password">Edit password: </label>--%>
<%--        <input type="text" id="password" name="password" value=${user.password_not_encoded}/>--%>
<%--        <br>--%>
<%--        <br>--%>
<%--        <input type="submit" value="Edit"/>--%>
<%--    </form>--%>

<%--</center>--%>


<%--<table border="1">--%>
<%--        <tr>--%>
<%--            <td>${user.userId}</td>--%>
<%--            <td>${user.email}</td>--%>
<%--            <td>${user.email}</td>--%>

<%--        </tr>--%>
<%--</table>--%>
</body>
</html>
