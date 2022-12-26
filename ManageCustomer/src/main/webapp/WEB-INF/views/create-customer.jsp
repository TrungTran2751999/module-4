<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 25/12/2022
  Time: 11:16 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form action="/create-customer" method="post">
        <label>Email</label>
        <input type="text" name="email" required>
        <label>Name</label>
        <input type="text" name="name" required>
        <input type="submit" value="Submit">
    </form>
</body>
</html>
