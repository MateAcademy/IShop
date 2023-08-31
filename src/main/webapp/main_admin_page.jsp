<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Admin page</title>
</head>
<body bgcolor="aqua">

<center>
    <h1> Success login!!!!!!!!!!!!!!! </h1>
</center>

<%
    Integer numberOfLogins = (Integer) session.getAttribute("numberOfLogins");
    if (numberOfLogins != null) {
        out.println("<h2> count = " + numberOfLogins + "</h2>");
    }
%>

<ul>
    <li><a href="/users">Список всех юзеров</a></li>
    <li><a href="/users/add">Добавить юзера</a></li>
    <li><a href="#">Список всех товаров</a></li>
    <li><a href="#">Добавить новый товар</a></li>
</ul>


</body>
</html>
