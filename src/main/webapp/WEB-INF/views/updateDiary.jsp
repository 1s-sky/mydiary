<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<body>
<button type="button" class="normal-btn" onclick="location.href='/loginHome';"><spring:message code="updated"/></button>
<center>
<div id="container">
    <form:form action="/updateDiary?did=${diary.did}" modelAttribute="diary" class="addDiary">
    <table>
    <h2><spring:message code="updateDiary"/> </h2>
    <tr>
        <td> <form:input path="title" placeholder="{diary.title}"/> </td>
        <td> <form:errors path="title"/></td>
    </tr>
    <tr>
        <td> <form:textarea path="text" placeholder="{diary.text}"/></td>
        <td><form:errors path="text"/></td>
    </tr>
    <tr>
        <td colspan="2" align="center">
        <button class="normal-btn" type="submit"><spring:message code="submit"/></button>
        <button class="normal-btn" type="reset" onclick="location.href='/updateMode';"> <spring:message code="back"/></button>
        </td>
    </tr>
    </table>
    </form:form>
</center>
</body>
<link rel="stylesheet" href="resources/css/diary.css">
</html>