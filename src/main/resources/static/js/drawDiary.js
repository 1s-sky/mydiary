let offset = {did:0, x:0, y:0};
window.onload = () => {
    document.querySelectorAll(".diary").forEach(function(element){
    //마우스 눌렀을 때
    element.addEventListener("mousedown", function(e) {
        offset.did = e.target.id;
        e.target.draggable = true;

    },false);
    //마우스 드래그
    element.addEventListener("mousemove", function(e) {
        if(!e.target.draggable) return ;
        offset.x = (e.clientX-50) + "px";
        offset.y = (e.clientY-50) + "px";
        e.target.style.left = offset.x;
        e.target.style.top  = offset.y;
        console.log(offset.x);
        }, false);
    //마우스 땠을 때
    element.addEventListener('mouseup', function(e) {
        event.currentTarget.draggable = false;
        $.ajax({
            type:"post",
            url:"/posData",
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
