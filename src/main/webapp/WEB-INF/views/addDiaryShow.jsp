<!DOCTYPE html>
<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<body>
<center>
<c:import url="http://localhost:8080/addDiary"></c:import>
<a href="./logout"><spring:message code="logout" /></a><br>
</center>
</body>
<link rel="stylesheet" href="resources/css/home.css">
</html>