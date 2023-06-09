<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<body>
<button type="button" onclick="location.href='/addDiary';">일기쓰기</button>
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
<script type="text/javascript" src="resources/js/drawDiary.js"></script>
<link rel="stylesheet" href="resources/css/home.css">
<script src="https://code.jquery.com/jquery-3.4.1.js"></script>
</script>
</html>