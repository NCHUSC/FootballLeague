$(function(){
	$("#submit").click(function(event){
		$.post("url",{
			name: $("#name").val(),
			id_card: $("#id_card").val(),
			user_email: $("#user_email").val(),
			phone: $("#phone").val()
		},function(data,textStatus){
			location.href = "send.html"
		})
	})
})