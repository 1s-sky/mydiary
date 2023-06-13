<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Home</title>
</head>
<body>
<div class="container">
<h2> MY DIARY </h2>

	<c:if test="${empty authinfo}">
	<div class="child">
		<p><spring:message code="greeting1" /></p>
		</div>
		<div class="child">
		<button class="user-btn" type="button" onclick="location.href='/signup';"><spring:message code="signup" /></button>
		<button class="user-btn" type="button" onclick="location.href='/login';"><spring:message code="login" /></button>
		</div>
	</c:if>

</body>
<link rel="stylesheet" href="resources/css/home.css">
</html>