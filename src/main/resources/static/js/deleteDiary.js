let offset = {did:0}
window.onload = () => {
    document.querySelectorAll(".delete-btn").forEach(function(element){
    //마우스 눌렀을 때
    element.addEventListener('click', function(e) {
        event.currentTarget.draggable = false;
        $.ajax({
            type:"post",
            url:"/deletedata",
            data:{ "did" : offset.did },
            dataType:"text",
            success:function(data){
            console.log("통신결과");
            console.log(data);
            }
        })
        .done(function(){ location.reload(); })
    }, false);
    })
}