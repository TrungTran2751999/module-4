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
    <form action="/caculate" method="post">
        <h2>Caculator</h2>
        <input type="hidden" name="action" id="action">
        <input type="text" name="var1">
        <input type="text" name="var2">

        <input type="submit" id="add" onclick="caculate('add')" value="Addition">
        <input type="submit" id="sub" onclick="caculate('sub')" value="Substraction">
        <input type="submit" id="multi" onclick="caculate('multi')" value="Multiplication">
        <input type="submit" id="division" onclick="caculate('division')" value="Division">
    </form>
    <script>
        function caculate(caculate) {
            document.getElementById("action").value = caculate;
        }
    </script>
</body>
</html>
