<#-- @ftlvariable name="users" type="java.util.List<com.avm.zoocode.db.entity.User>" -->
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <title>List of Users</title>
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
        <li><a href="/">Home</a></li>
        <li><a href="/create">Create a new user</a></li>
    </ul>
</nav>

<h1>List of Users</h1>

<table>
    <thead>
    <tr>
        <th>E-mail</th>
    </tr>
    </thead>
    <tbody>
    <#list users as user>
    <tr>
        <td>${user.email}</td>
        <td>${user.birthDate}</td>
        <td>${user.street}</td>
        <td>${user.city}</td>
        <td>${user.country}</td>
        <td>${user.zipCode}</td>
    </tr>
    </#list>
    </tbody>
</table>
</body>
</html>