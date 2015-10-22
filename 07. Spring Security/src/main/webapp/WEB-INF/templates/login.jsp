<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: root
  Date: 22.10.15
  Time: 11:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
</head>
<body>
<h1>Збс форма внатури своя</h1>
<c:if test="${not empty error}">
    Неправильный логин или пароль!!!
</c:if>
<form action="/login/process" method="post">
    <label>
        <input type="text" name="login">
    </label>
    <label>
        <input type="text" name="password">
    </label>
    <input type="submit">
</form>

</body>
</html>
