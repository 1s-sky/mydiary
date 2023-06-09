<!DOCTYPE html>
<%@ page contentType="text/html; charset=utf-8" %>
<html>
<body>
<form action="/addDiary" method="post">
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
    <button type="submit">기록하기</button>
    <button type="reset"> 취소</button>
    </td>
</tr>
</table>
</form>
</body>
</html>