$(function(){
	$("#submit").click(function(event){
		$.post("url",{
			send_to_address: $("#send_to_address").val(),
			send_to_name: $("#send_to_name").val(),
			send_to_phone: $("#send_to_phone").val(),
			weight: $("#weight").val(),
			Remark: $("#Remark").val()
		},function(data,textStatus){
			location.href = "sent.html"
		})
	})
})