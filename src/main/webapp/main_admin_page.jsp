<%--
  Created by IntelliJ IDEA.
  User: Sergey
  Date: 11.08.2023
  Time: 3:20
  To change this template use File | Settings | File Templates.
--%>
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
    Integer countUserEnterToLogin = (Integer) session.getAttribute("count");
    if (countUserEnterToLogin != null) {
        out.println("<h2> count = " + countUserEnterToLogin + "</h2>");
    }
%>

</body>
</html>
