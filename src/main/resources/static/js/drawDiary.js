let offset = {did:0, x:0, y:0};
window.onload = () => {
    document.querySelectorAll(".diary").forEach(function(element){

    element.addEventListener("mousedown", function(e) {
        offset.did = e.target.id;
        e.target.draggable = true;

    },false);
    element.addEventListener("mousemove", function(e) {
        if(!e.target.draggable) return ;
        offset.x = (e.clientX-20) + "px";
        offset.y = (e.clientY-20) + "px";
        e.target.style.left = offset.x;
        e.target.style.top  = offset.y;
        console.log(offset.x);
        }, false);

    element.addEventListener('mouseup', function(e) {
        event.currentTarget.draggable = false;
        $.ajax({
            type:"post",
            url:"/postData",
            data:{ "did" : offset.did, "xpos" : offset.x, "ypos" : offset.y},
            dataType:"text",
            success:function(data){
            console.log("통신결과");
            console.log(data);
            }
        })
    }, false);

    element.addEventListener("contextmenu", function(e) {
            e.target.draggable=false;
            e.preventDefault();
            offset.x = "50px";
            offset.y = "50px";
            e.target.style.left = offset.x;
            e.target.style.top  = offset.y;
            console.log(offset.x);

        $.ajax({
            type:"post",
            url:"/postData",
            data:{ "did" : offset.did, "xpos" : offset.x, "ypos" : offset.y},
            dataType:"text",
            success:function(data){
            console.log("통신결과");
            console.log(data);
            }
        })
    }, false);
    })
}

    function onClick(){
        for(let i of diary_list) {
        $.ajax({
            type:"post",
            url:"/postData",
            data:{ "did" : diary_list[i].did, "xpos" : diary_list[i].x, "ypos" : diary_list.y},
            dataType:"text",
            success:function(data){
                console.log("통신결과");
                console.log(data);
            }
        })
        }
//        var posData = document.createElement("form"); // 폼객체 생성
//        posData.setAttribute("charset", "UTF-8");
//        posData.setAttribute("method", "POST"); //POST
//        posData.setAttribute("action", "/updateDiary");
//
//        var xpos = document.createElement("input"); // input 객체 생성
//        xpos.setAttribute("type", "text");
//        xpos.setAttribute("name", "xpos");
//        xpos.setAttribute("value", offset.x);
//        posData.appendChild(xpos); // 폼에 추가 실시
//
//        var ypos = document.createElement("input"); // input 객체 생성
//        ypos.setAttribute("type", "text");
//        ypos.setAttribute("name", "ypos");
//        ypos.setAttribute("value", offset.y);
//        posData.appendChild(ypos); // 폼에 추가 실시
//
//        document.body.appendChild(posData); //body에 폼 레이아웃 추가
//        posData.submit(); //실행 및 제출 실시
//        document.body.removeChild(posData); //body에서 폼 레이아웃 삭제
    }
