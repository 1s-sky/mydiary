<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<body>
<button class="normal-btn" type="button" onclick="location.href='/addDiary';">일기쓰기</button>
<button class="normal-btn" type="button" onclick="location.href='/updateMode';">수정하기</button>
<button class="normal-btn" type="button" onclick="location.href='./logout';"><spring:message code="logout" /></button>
<div id="container">
    <c:forEach var="item" items="${diaryList}">
        <div class="diary" id ="${item.did}" style="position:absolute; left:${item.xpos}px; top: ${item.ypos}px"
         draggable = false>
            ${item.title}<br>
            ${item.text}

        </div>
    </c:forEach>
</div>
  </table>
</body>
<script type="text/javascript" src="resources/js/drawDiary.js?a"></script>
<link rel="stylesheet" href="resources/css/diary.css?a">
<script src="https://code.jquery.com/jquery-3.4.1.js"></script>
</script>
</html>