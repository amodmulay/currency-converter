<#-- @ftlvariable name="_csrf" type="org.springframework.security.web.csrf.CsrfToken" -->
<#-- @ftlvariable name="currentUser" type="java.util.List<com.avm.zoocode.service.dto.UserDetailsExt" -->
<#-- @ftlvariable name="rates" type="java.util.Map<com.avm.zoocode.service.dto.currency.ExchangeRateDto" -->

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <title>Home page</title>
</head>
<body>
<div>
<h1>Welcome to Currency Converter Demonstrator</h1>
</div>

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
            <form action="/logout" method="post">
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                <button type="submit">Log out</button>
            </form>
        </li>
        <li><a href="/user/${currentUser.id}">View myself</a></li>
    </#if>
        <li><a href="/create">Create an account</a></li>
    </ul>
</nav>
</div>
</td>
<td height="100">
<div>
<#list rates.rates?keys as key> 
    <p>${key} = ${rates.rates[key]} </p>
</#list> 
</div>
</td>
</tr>
</table>
</body>
</html>