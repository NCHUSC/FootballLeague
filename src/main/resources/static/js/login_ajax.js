var rurl = apphost+"/index.html?g=logistics&m=user&a=register";
var lurl = apphost+"/index.html?g=logistics&m=user&a=do_login";
$(function(){
	$("#submit").click(function(event){
		$.post(rurl,{
			username: $("#account").val(),
			useremail: $("#user_email").val(),
			phone: $("#phone").val(),
			password: $("#password").val()
		},function(data){
			if(data.success){
				location.href = "login.html";
			}else{
				alert("网络错误，请稍后重试！");
			}
			
		},
		"json")
	})
})
$(function(){
	$("#button").click(function(event){
		$.post(lurl,{
			username: $("#account").val(),
			password: $("password").val()
		},function(data){
			if (data.success) {
				location.href = "index.html"
			}
			else{
				alert("登陆失败");
			}
				
		},
		"json")
	})
})