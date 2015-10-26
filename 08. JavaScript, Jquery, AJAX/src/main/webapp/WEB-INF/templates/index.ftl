<#assign security=JspTaglibs["http://www.springframework.org/security/tags"] />

<#include "main-template.ftl">
<#macro m_body>
<div class="col-lg-6 col-lg-offset-3">
    <textarea id="js-tweet-text" class="form-control" rows="3" title="tweet"></textarea>
    <input type="submit" id="js-sendtweet">
</div>
<div id="js-tweets" class="col-lg-6 col-lg-offset-3"></div>
</#macro>

<@main title="Главная страница" customScripts=["/resources/js/tweets.js"]/>
