<%@ page import="ua.ishop.klunniy.model.User" %>
<%@ page import="java.util.List" %>
<%@ page import="java.io.PrintWriter" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>All Users</title>
</head>
<body>

<table border="1">
  <c:forEach items="${allProducts}" var="element">
    <tr>
      <td>${element.productId}</td>
      <td>${element.name}</td>
      <td>${element.description}</td>
      <td><a href="/products/update?productId=${element.productId}">edit</a></td>
      <td><a href="#">delete</a></td>
    </tr>
  </c:forEach>
</table>

</body>
</html>
