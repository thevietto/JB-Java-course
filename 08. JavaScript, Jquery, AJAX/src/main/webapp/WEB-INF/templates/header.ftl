<#assign security=JspTaglibs["http://www.springframework.org/security/tags"] />
<@security.authorize access="hasAnyRole('ROLE_USER', 'ROLE_ADMIN')">
    <@security.authentication property="principal.username" var="username"/>
</@security.authorize>
<header>
    <div class="col-lg-3 col-lg-offset-9 userside">
    <#if username??>
    <p>${username}</p>
    <#else>
        <p><a href="/registration">Зарегистироваться</a> или <a href="/login">Войти</a></p>
    </#if>
    </div>
</header>