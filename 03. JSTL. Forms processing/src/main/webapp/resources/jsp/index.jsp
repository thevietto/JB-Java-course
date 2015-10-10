<%@ taglib prefix="spring" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Тест</title>
</head>
<body>
<h1>It works!</h1>

<spring:form method="post" modelAttribute="user" action="/save">
    <spring:label path="name">Имя:</spring:label>
    <spring:input path="name"/> <br>
    <spring:errors path="name"/>

    <spring:label path="login">Логин:</spring:label>
    <spring:input path="login"/><br>
    <spring:errors path="login"/>

    <spring:label path="password">Пароль:</spring:label>
    <spring:password path="password"/><br>
    <spring:errors path="password"/>

    <button type="submit">Sent</button>
</spring:form>

</body>
</html>
