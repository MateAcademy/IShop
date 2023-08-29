<%@ page import="ua.ishop.klunniy.model.User" %>
<%@ page import="java.util.List" %>
<%@ page import="java.io.PrintWriter" %>
<%--<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%--
  Created by IntelliJ IDEA.
  User: Sergey
  Date: 06.08.2023
  Time: 12:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>All Users</title>
</head>
<body>

<%--<%--%>
<%--    PrintWriter printWriter = response.getWriter();--%>
<%--    printWriter.write("<table border=1>\n" +--%>
<%--            "    <tr>\n" +--%>
<%--            "        <th>Email</th>\n" +--%>
<%--            "        <th>Password</th>\n" +--%>
<%--            "    </tr>");--%>

<%--     List<User> allUsers = (List<User>) request.getAttribute("allUsers");--%>
<%--     for (User user: allUsers) {--%>
<%--         printWriter.write("<tr>");--%>
<%--         printWriter.write("<td>" + user.getEmail() + "</td>");--%>
<%--         printWriter.write("<td>" + user.getPassword() + "</td>");--%>
<%--         printWriter.write("</tr>");--%>
<%--     }--%>

<%--%>--%>
<table border="1">
<c:forEach items="${allUsers}" var="element">
    <tr>
        <td><c:out value="${element.email}"/></td>
        <td><c:out value="${element.password}"/></td>
    </tr>
</c:forEach>
</table>



<%--<table border="1">--%>
<%--    <c:forEach items="${allUsers}" var="element">--%>
<%--        <tr>--%>
<%--            <td>${element.email}</td>--%>
<%--            <td>${element.password}</td>--%>
<%--        </tr>--%>
<%--    </c:forEach>--%>
<%--</table>--%>

    </body>
    </html>
