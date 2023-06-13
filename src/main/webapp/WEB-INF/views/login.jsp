<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
</head>
<body>
<h2><spring:message code="login" /></h2>

<% request.setCharacterEncoding("UTF-8"); %>

<form:form novalidate="novalidate" action="loginSubmit" modelAttribute="loginCommand">
	<p> <label> <spring:message code="id" />:
	<form:input path="id" /><br>
	<form:errors path="id" /> </label> </p>
	<p> <label> <spring:message code="pw" />:
	<form:input path="pw" /><br>
	<form:errors path="pw" /> </label> </p>
	<form:errors /><br>
	<button class="user-btn" type="submit"> <spring:message code="login" /> </button>
	<button class="user-btn" type="button" onclick="location.href='/';"><spring:message code="back" /></button>
</form:form>

</body>
<link rel="stylesheet" href="resources/css/home.css?b">
</html>