$(function(){
	$("#submit").click(function(event){
		$.post("url",{
			forget_user_email: $("#forget_user_email").val()
		},function(data,textStatus){
			location.href = "sent.html"
		})
	})
})