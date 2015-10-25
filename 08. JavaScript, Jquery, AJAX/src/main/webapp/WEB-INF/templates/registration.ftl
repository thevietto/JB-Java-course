<#assign sf=JspTaglibs["http://www.springframework.org/tags/form"]>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Registration</title>
    <link rel="stylesheet" type="text/css" href="/resources/css/bootstrap.css"/>
</head>
<body>

<div class="col-md-4 col-md-offset-4">
<@sf.form action="/registration" method="post" modelAttribute="userform">
    <div class="form-group">
        <label for="username">Логин</label>
        <@sf.input path="username" id="username" cssClass="form-control" placeholder="Логин"/>
        <@sf.errors path="username"/>
    </div>
    <div class="form-group">
        <label for="password">Пароль</label>
        <@sf.input path="password" id="password" cssClass="form-control" placeholder="Пароль"/>
        <@sf.errors path="password"/>
    </div>
    <div class="form-group">
        <label for="repassword">Ещё раз</label>
        <@sf.input path="repassword" id="repassword" cssClass="form-control" placeholder="Повторите пароль"/>
        <@sf.errors path="repassword"/>
    </div>
    <button type="submit" class="btn btn-default">Submit</button>
</@sf.form>
</div>
</body>
</html>
