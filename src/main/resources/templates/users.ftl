<#-- @ftlvariable name="users" type="java.util.List<com.avm.zoocode.db.entity.User>" -->
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <title>List of Users</title>
</head>
<body>
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
        <td><a href="/user/${user.id}">${user.email}</a></td>
        <td><a href="/user/${user.id}">${user.birthDate}</a></td>
        <td><a href="/user/${user.id}">${user.street}</a></td>
        <td><a href="/user/${user.id}">${user.city}</a></td>
        <td><a href="/user/${user.id}">${user.country}</a></td>
        <td><a href="/user/${user.id}">${user.zipCode}</a></td>
    </tr>
    </#list>
    </tbody>
</table>
</body>
</html>