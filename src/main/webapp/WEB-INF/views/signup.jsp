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
	<form:input path="id" />
	<form:errors path="id" /> </label> </p>
	<p> <label> <spring:message code="pw" />:<br>
	<form:input path="pw" /> <form:errors path="pw" /> </label> </p>
	<form:errors /><br>
	<button class="btn" type="submit"> <spring:message code="submit" /> </button>
</form:form>

	<a href="./"><spring:message code="back"/></a>
</body>
<link rel="stylesheet" href="resources/css/home.css">
</html>