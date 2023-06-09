<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<body>
<button type="button" onclick="location.href='/addDiary';">일기쓰기</button>

<div id="table"></div>

    <script src="drawDiary.js"></script>

    <script type="text/javascript">
        widget.init("table", function () {
        }); // widget 그리기
    </script>
</body>
</html>