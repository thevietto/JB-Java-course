<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: root
  Date: 07.10.15
  Time: 15:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Перешли на новую страницу</h1>

<sf:form method="post" modelAttribute="user" action="/save">
    Имя: <sf:input path="name"/> <br>
    Фамилия: <sf:input path="surname"/> <br>
    <button type="submit">Отправить</button>
</sf:form>

</body>
</html>
