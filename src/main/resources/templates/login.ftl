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

<h1>Log in</h1>

<form role="form" action="/login" method="post">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
    <div>
        <label for="email">Email address</label>
        <input type="email" name="email" id="email" required autofocus/>
    </div>
    <div>
        <label for="password">Password</label>
        <input type="password" name="password" id="password" required/>
    </div>
    <div>
        <label for="remember-me">Remember me</label>
        <input type="checkbox" name="remember-me" id="remember-me"/>
    </div>
    <button type="submit">Sign in</button>
</form>

<#if error.isPresent()>
<p>The email or password you have entered is invalid, try again.</p>
</#if>
</body>
</html>