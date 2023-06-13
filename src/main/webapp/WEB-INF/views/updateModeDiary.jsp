<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<body>
<button type="button" class="normal-btn" onclick="location.href='/loginHome';">수정완료</button>
<div id="container">
    <c:forEach var="item" items="${diaryList}">

        <div class="diary" id ="${item.did}" style="position:absolute; left:${item.xpos}px; top: ${item.ypos}px"
         draggable = false>
         <div>
            ${item.title}<br>
            ${item.text}
            <p>
            <button class="update-btn" id ="${item.did}" type="button" onclick="location.href='/updateDiary?did=${item.did}';"><spring:message code="update"/></button>
            <button class="delete-btn" id ="${item.did}" type="button"><spring:message code="delete"/></button>
            </p>
        </div>
        </div>
    </c:forEach>
</div>
  </table>
</body>
<script type="text/javascript" src="resources/js/deleteDiary.js"></script>
<link rel="stylesheet" href="resources/css/diary.css?a">
<script src="https://code.jquery.com/jquery-3.4.1.js"></script>
</html>