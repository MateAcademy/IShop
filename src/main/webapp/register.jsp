<%--
  Created by IntelliJ IDEA.
  User: Sergey
  Date: 02.08.2023
  Time: 19:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Register User</title>
</head>
<body>

<center>
<p>
    <%
        String error = (String) request.getAttribute("error");
        if (error != null) {
            response.getWriter().write(error);
        }
    %>
</p>
    <form action="/register" method="post">
        Email<input name="email" type="email"/> <br>
        Password <input name="password" type="password"/> <br>
        Repeat password <input name="rpassword" type="password"/> <br>
        <button type="submit">Register</button>
    </form>
</center>

<%


%>


</body>
</html>
