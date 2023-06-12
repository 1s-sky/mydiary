<!DOCTYPE html>
<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<body>
<center>
<form action="/addDiary" method="post" name="dinput">
<table>
<tr>
    <td> 제목 </td>
    <td> <input type = "text" name = "title"> </td>
</tr>
<tr>
    <td> 내용</td>
    <td> <textarea name="text"></textarea></td>
</tr>
<tr>
    <td colspan="2" align="center">
    <button class="normal-btn" type="submit">기록하기</button>
    <button class="normal-btn" type="reset"> 취소</button>
    </td>
</tr>
</table>
</form>
</center>
</body>
<link rel="stylesheet" href="resources/css/home.css">
</html>