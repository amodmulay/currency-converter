<#-- @ftlvariable name="_csrf" type="org.springframework.security.web.csrf.CsrfToken" -->
<#-- @ftlvariable name="currentUser" type="java.util.List<org.springframework.security.core.userdetails.User" -->
<#-- @ftlvariable name="rates" type="java.util.Map<com.avm.zoocode.service.dto.currency.ExchangeRateDto" -->

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <title>Currency Converter</title>
        <link rel="stylesheet" href="http://code.jquery.com/ui/1.10.3/themes/smoothness/jquery-ui.css" />
    <link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.0.0-rc1/css/bootstrap.min.css">
</head>
<body>
<div>
<h1>Currency Converter :: Spring Boot + Spring MVC + JPA + Freemarker</h1>
</div>
</br>

<table style="width:100%">
<tr>
<td>
<div>
<nav role="navigation">
    <ul>
    <#if !currentUser??>
        <li><a href="/login">Registered users Log in here</a></li>
    </#if>
    <#if currentUser??>
        <li>
            <form action="/" method="post">
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                <button type="submit">Log out</button>
            </form>
        </li>
        <li><a href="/converter">Currency Converter</a></li>
    </#if>
    <#if !currentUser??>
        <li><a href="/create">Create an account</a></li>
    </#if>    
    </ul>
</nav>
</div>
</td>
<#--
<td height="100">
<div>
<#list rates.rates?keys as key> 
    <p>${key} = ${rates.rates[key]} </p>
</#list> 
</div>
</td>
-->
</tr>
</table>
</body>
</html>