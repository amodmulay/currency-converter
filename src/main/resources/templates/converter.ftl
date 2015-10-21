<#-- @ftlvariable name="_csrf" type="org.springframework.security.web.csrf.CsrfToken" -->
<#-- @ftlvariable name="currentUser" type="java.util.List<com.avm.zoocode.service.dto.UserDetailsExt" -->
<#-- @ftlvariable name="convert" type="com.avm.zoocode.service.dto.currency.ExchangeRequestDto" -->
<#-- @ftlvariable name="rates" type="java.util.Map<com.avm.zoocode.service.dto.currency.ExchangeRateDto" -->
<#-- @ftlvariable name="activity" type="java.util.List<com.avm.zoocode.db.entity.ActivityLog" -->
<#import "/spring.ftl" as spring>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <title>List of Users</title>
</head>
<body>
<div>
<h1>Currency Converter :: Spring Boot + Spring MVC + JPA + Freemarker</h1>
</div>
</br>
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
        <li><a href="/home">Home Page</a></li>
    </#if>
    </ul>
</nav> 

<h1>Currency Converter</h1>
<form role="form" name="form" action="" method="post">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
</br>
<div>
<label for="fromCurreny">Convert From</label>
<select id="fromCurreny" name="fromCurreny">
<#list rates.rates?keys as key>  
<option value="${key}">${key}</option>
</#list> 
</select>
</div>
</br>
<div>
<label for="toCurrency">Convert To</label>
<select id="toCurrency" name="toCurrency">
<#list rates.rates?keys as key> 
<option value="${key}">${key}</option>
</#list> 
</select>
</div>
</br>
<div>
<label for="valueToConvert">Amount to Covert</label>
<input type="text" name="valueToConvert" id="valueToConvert"  required/>
</div>

<#if convert.covertedValue??>
</br>
<div>
<label for="covertedValueLable">Exchange Value from ${convert.fromCurreny} to ${convert.toCurrency} </label>
<label for="covertedValue">${convert.covertedValue}</label>
</br>
<label for="covertedValueDate">Calculated on the basis of rates available on: ${.now}</label>
</div>
</#if>
</br>
<button type="submit">Convert</button>
</form>
<#if activity??>
 <#list activity as log>
        <li>${log}</li>
  </#list>
</#if>
<@spring.bind "convert" />
<#if spring.status.error>
<ul>
    <#list spring.status.errorMessages as error>
        <li>${error}</li>
    </#list>
</ul>
</#if>
</body>
</html>