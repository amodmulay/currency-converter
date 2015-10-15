<#-- @ftlvariable name="_csrf" type="org.springframework.security.web.csrf.CsrfToken" -->
<#-- @ftlvariable name="currentUser" type="java.util.List<com.avm.zoocode.service.dto.UserDetailsExt" -->
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
</body>
</html>