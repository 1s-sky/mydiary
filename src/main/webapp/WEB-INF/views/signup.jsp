<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 가입</title>
</head>
<body>
<h2><spring:message code="signup" /></h2>

<% request.setCharacterEncoding("UTF-8"); %>

<form:form novalidate="novalidate" action="submit" modelAttribute="user">
	<p> <label> <spring:message code="id" />:<br>
	<form:input path="id" /><br>
	<form:errors path="id" /> </label> </p>
	<p> <label> <spring:message code="pw" />:<br>
	<form:input path="pw" /><br>
	<form:errors path="pw" /> </label> </p>
	<form:errors /><br>
	<button class="user-btn" type="submit"><spring:message code="signup" /></button>
	<button class="user-btn" type="button" onclick="location.href='/';"><spring:message code="back" /></button>

</form:form>

</body>
<link rel="stylesheet" href="resources/css/home.css">
</html>