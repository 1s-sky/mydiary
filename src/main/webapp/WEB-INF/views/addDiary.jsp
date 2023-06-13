<!DOCTYPE html>
<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<body>
<center>
<form:form action="/addDiary" modelAttribute="diary">
<h2><spring:message code="adddiary"/> </h2>
<table>
<tr>
    <td> <spring:message code="title"/> </td>
    <td> <form:input path="title"/> </td>
    <td> <form:errors path="title"/></td>
</tr>
<tr>
    <td> <spring:message code="text"/></td>
    <td> <form:textarea path="text"/></td>
    <td><form:errors path="text"/></td>
</tr>
<tr>
    <td colspan="2" align="center">
    <button class="normal-btn" type="submit"><spring:message code="submit"/></button>
    <button class="normal-btn" type="reset"> <spring:message code="back"/></button>
    </td>
</tr>
</table>
</form:form>
</center>
</body>
<link rel="stylesheet" href="resources/css/home.css?a">
</html>