<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%--
  Created by IntelliJ IDEA.
  User: root
  Date: 22.10.15
  Time: 10:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Панель управления</title>
</head>
<body>
<h1>Панель управления</h1>

<h2>Привет, <security:authentication property="principal.username"/>!</h2>

<security:authorize access="hasRole('ROLE_USER')">
    <p>Функционал юзера</p>
</security:authorize>
<security:authorize access="hasRole('ROLE_ADMIN')">
    <p>Функционал админа</p>
</security:authorize>

</body>
</html>
