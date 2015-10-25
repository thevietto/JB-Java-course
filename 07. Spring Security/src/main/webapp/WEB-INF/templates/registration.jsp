<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: root
  Date: 24.10.15
  Time: 16:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Registration</title>
</head>
<body>
<sf:form action="/registration" method="post" modelAttribute="userform">

    <sf:label path="username">Login: </sf:label> <sf:input path="username"/>
    <sf:label path="password">password: </sf:label> <sf:input path="password"/>
    <sf:label path="repassword">repassword: </sf:label> <sf:input path="repassword"/>

    <button type="submit">Сохранить</button>
</sf:form>
</body>
</html>
