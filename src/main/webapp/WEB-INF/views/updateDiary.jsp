<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<body>
<button type="button" class="normal-btn" onclick="location.href='/loginHome';">수정완료</button>
<div id="container">
    <form:form action="/updatediary?did=${diary.did}" modelAttribute="diary">
    <div class="diary" id ="${diary.did}" style="position:absolute; left:${diary.xpos}px; top: ${diary.ypos}px"
             draggable = false>

    <table>
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
        <button class="normal-btn" type="reset"> <spring:message code="back"/></button>
        </td>
    </tr>
    </table>
            </div>
    </form:form>

</body>
<link rel="stylesheet" href="resources/css/diary.css">
</html>