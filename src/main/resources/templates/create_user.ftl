<#-- @ftlvariable name="_csrf" type="org.springframework.security.web.csrf.CsrfToken" -->
<#-- @ftlvariable name="userDto" type="com.avm.zoocode.db.dto.UserDto" -->
<#import "/spring.ftl" as spring>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <title>Create a new user</title>
    <meta charset="utf-8" />
    <title>User Screen</title>
	<script type="text/javascript" src="/lib/AJAXLibs.js"></script>
    <script src="http://code.jquery.com/jquery-1.9.1.js"></script>
    <script src="http://code.jquery.com/ui/1.10.3/jquery-ui.js"></script>
    <script src="//netdna.bootstrapcdn.com/bootstrap/3.0.0-rc1/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="http://code.jquery.com/ui/1.10.3/themes/smoothness/jquery-ui.css" />
    <link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.0.0-rc1/css/bootstrap.min.css">
</head>
<body>
<nav role="navigation">
    <ul>
        <li><a href="/">Home</a></li>
    </ul>
</nav>

<h1>Create a new user</h1>

<form role="form" name="form" action="" method="post">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
    <div>
        <label for="email">Email address</label>
        <input type="email" name="email" id="email" value="${userDto.email}" required autofocus/>
    </div>
    <div>
        <label for="password">Password</label>
        <input type="password" name="password" id="password" required/>
    </div>
    <div>
        <label for="passwordRepeated">Repeat</label>
        <input type="password" name="passwordRepeated" id="passwordRepeated" required/>
    </div>
    <div>
        <label for="birthDate">Birth Date</label>
       <input type="text" id="birthDate" name="birthDate" required/>
    </div>
    <div>
        <label for="street">Street</label>
        <input type="text" id="street" name="street" required/>
    </div>
    
    <div>
         <label for="zipCode">Zip Code</label>
         <input type="text" id="zipCode" name="zipCode" required/>
    </div>
    <div>
         <label for="city">City</label>
         <input type="text" id="city" name="city" required/>
    </div>
    <div>
         <label for="country">Country</label>
         <input type="text" id="country" name="country" required/>
    </div>

    <button type="submit">Save</button>
</form>

<@spring.bind "userDto" />
<#if spring.status.error>
<ul>
    <#list spring.status.errorMessages as error>
        <li>${error}</li>
    </#list>
</ul>
</#if>
<script type="text/javascript">

window.onload=function(){
    //Datepicker for Date of Birth
    $( "#birthDate" ).datepicker();
};

 </script>
</body>
</html>