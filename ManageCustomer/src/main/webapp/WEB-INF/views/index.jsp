<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 25/12/2022
  Time: 9:25 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Manage Customer</title>
</head>
<body>
  <table>
    <caption>Manage Customer</caption>
    <thead>
      <tr>
        <th>Stt</th>
        <th>ID</th>
        <th>Email</th>
        <th>Name</th>
      </tr>
    </thead>
    <% int stt=1; %>
    <tbody>
        <c:forEach items="${customers}" var="customer">
          <tr>
            <th><%= stt++%></th>
            <th>${customer.getId()}</th>
            <th>${customer.getEmail()}</th>
            <th>${customer.getName()}</th>
          </tr>
        </c:forEach>
    </tbody>
  </table>
</body>
</html>
