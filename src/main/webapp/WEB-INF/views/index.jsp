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
	<h2> MY DIARY </h2>
	<c:if test="${empty authinfo}">
		<p><spring:message code="greeting1" /></p>
		<a href="./signup"><spring:message code="signup" /></a><br>
		<a href="./login"><spring:message code="login" /></a>
	</c:if>
	
	<c:if test="${! empty authinfo}">
	<!-- 로그인된 경우 ; 여기에 달력이랑 일기 정보 넣기..? -->
	<c:import url="http://localhost:8080/loginHome"></c:import>
		<p>${authinfo.id}님, <spring:message code="greeting2" /></p>
		<a href="./logout"><spring:message code="logout" /></a><br>
	</c:if>

</body>
<link rel="stylesheet" href="resources/css/home.css">
</html>