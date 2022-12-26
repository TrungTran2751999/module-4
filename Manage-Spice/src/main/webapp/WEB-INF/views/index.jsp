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
  <table border="1">
    <caption>Manage Customer</caption>
    <thead>
      <tr>
        <th>Stt</th>
        <th>ID</th>
        <th>Name</th>
        <th>Spice</th>
      </tr>
    </thead>
    <% int stt=1; %>
    <tbody>
        <c:forEach items="${customers}" var="customer">
          <tr>
            <th><%= stt++%></th>
            <th>${customer.getId()}</th>
            <th>${customer.getName()}</th>
            <th>
                <c:forEach items="${customer.spice}" var="spice">
                  ${spice},
                </c:forEach>
            </th>
          </tr>
        </c:forEach>
    </tbody>
  </table>
</body>
</html>
