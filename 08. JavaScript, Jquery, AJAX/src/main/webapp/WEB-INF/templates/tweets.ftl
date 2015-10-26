<#list tweets as tweet>
${tweet.text}<br>
${tweet.createdAt} by ${tweet.user.username}
<hr>
</#list>