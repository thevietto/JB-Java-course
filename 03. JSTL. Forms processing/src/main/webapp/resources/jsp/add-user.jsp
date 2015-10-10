<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1> Добавление нового пользователя: </h1>

<sf:form action="/users/add_user" method="post" modelAttribute="user">
    <sf:label path="name">Имя: </sf:label> <sf:input path="name"/> <br>
    <sf:label path="surname">Фамилия: </sf:label> <sf:input path="surname"/> <br>
    <sf:label path="login">Логин: </sf:label> <sf:input path="login"/> <br>
    <sf:label path="age">Возвраст: </sf:label> <sf:input path="age"/> <br>
    <sf:label path="password">Пароль: </sf:label> <sf:password path="password"/> <br>

    <button type="submit">Сохранить</button>
</sf:form>

</body>
</html>
