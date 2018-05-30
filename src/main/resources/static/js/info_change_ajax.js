$(function(){
	$("#submit").click(function(event){
		$.post("url",{
			info_user_name: $("#info_user_name").val(),
			info_user_email: $("#info_user_email").val(),
			info_phone: $("#info_phone").val(),
			info_passward: $("#info_passward").val()
		},function(data,textStatus){
			location.href = "menu.html"
		})
	})
})