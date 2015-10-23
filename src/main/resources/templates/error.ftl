<#-- @ftlvariable name="_csrf" type="org.springframework.security.web.csrf.CsrfToken" -->
<#-- @ftlvariable name="error" type="java.util.Optional<String>" -->
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
<nav role="navigation">
    <ul>
        <li><a href="/">Home Page</a></li>
    </ul>
</nav>

<h1>Opps! Something went wrong. No food for the developer today!!!</h1>

<#if error.isPresent()>
<p>${error}</p>
</#if>
</body>
</html>