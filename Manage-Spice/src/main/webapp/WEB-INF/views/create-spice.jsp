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
    <form action="/create-spice" method="post">
        <h2>Food Condiments</h2>
        <label>Name of Disk</label>
        <input type="text" name="name">
        <label>Tomato</label>
        <input type="checkbox" name="condiment" value="Tomato">
        <label>Lettuce</label>
        <input type="checkbox" name="condiment" value="Lettuce">
        <label>Mustard</label>
        <input type="checkbox" name="condiment" value="Mustard">
        <label>Sprourd</label>
        <input type="checkbox" name="condiment" value="Sprourd">
        <input type="submit" value="Submit">
    </form>
</body>
</html>
