<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Create a new user</title>
</head>
<body>
<h3>Welcome, Enter The Employee Details</h3>
<form:form method="post" action="login" modelAttribute="user">
    <table>
        <tr>
            <td><form:label path="name">Name:</form:label></td>
            <td><form:input path="name"/></td>
        </tr>
        <tr>
            <td><form:label path="password">Password: </form:label></td>
            <td><form:password path="password"/></td>
        </tr>
        <tr>
            <td></td>
            <td><input type="submit" value="Submit"></td>
        </tr>
    </table>
    <a href="/register">Register</a>
</form:form>
<div style="color: red"><c:if test="${message != null}">${message}</c:if></div>
</body>
</html>