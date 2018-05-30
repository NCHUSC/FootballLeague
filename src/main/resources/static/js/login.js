$(".signin").click(function(){
    this.className="signin focus";
    $(".signup")[0].className="signup";
    $(".input_signin")[0].className="input_signin active";
    $(".input_signup")[0].className="input_signup";
});
$(".signup").click(function(){
    this.className="signup focus";
    $(".signin")[0].className="signin";
    $(".input_signup")[0].className="input_signup active";
    $(".input_signin")[0].className="input_signin";
});

/*$("#login").click(function () {
    $.ajax({
        type:"POST",
        url:"/index.html",
        data:{
            "account":$("#account").val(),
            "password":$("#password").val()
        },
        success:function (result) {
            var arr=result.split("@#@");
            if(arr[0]=="0"){
                window.location.href="/index";
            }else{
                alert(arr[1]);
                reset();
            }
        }
    })
})*/

