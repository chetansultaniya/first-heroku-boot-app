var sendURL = "/app";
var fetchURL = "/queue";
var securityKey = null;
var stompClient = null;

function connect()
{
	
	var sockJs = new SockJS('/chetchat');
    stompClient = Stomp.over(sockJs);
    
    // for private chat
    securityKey = $('#key').val();
    sendURL = "/app/" + securityKey;
    fetchURL = "/queue/" + securityKey;
    
    stompClient.connect({},function(response){
    	
    	// code for connection successfully
    	stompClient.subscribe(fetchURL + '/connect' , function(res){
    		var obj = JSON.parse(res.body);
    	});
    	
    	stompClient.subscribe(fetchURL + '/message' , function(res){
    		var obj = JSON.parse(res.body);
    		displayMessage(obj);
    	});
    	
    },function(error){
    	// code when not connected
    	console.log("stomClient() is giving error");
    });
    
}

function sendMessage()
{
	stompClient.send(sendURL + '/message', {}, JSON.stringify({
        name: $('#name').val(),
        content: $('#message').val(),
    }));
    $('#message').val('');
}
function displayMessage(msg)
{
	if($('#name').val()=== msg.name)
	{
		$('#chatmessage').append("<div class='d-flex justify-content-end mb-4'>"+
				"<span class='msg_time'>"+msg.time+"</span>"+
				"<div class='msg_cotainer_send'>"+msg.content+
				"</div>"+
				"<div class='img_cont_msg'>"+
				"<img src='https://static.turbosquid.com/Preview/001292/481/WV/_D.jpg' class='rounded-circle user_img_msg'>"+
			"</div>"+
		"</div>");	
	}
	else
	{
		$('#chatmessage').append("<div class='d-flex justify-content-start mb-4'>"+
				"<div class='img_cont_msg'>"+
					"<img src='https://static.turbosquid.com/Preview/001292/481/WV/_D.jpg' class='rounded-circle user_img_msg'>"+
				"</div>"+
				"<div class='msg_cotainer'>"+msg.content+
				"</div>"+	
				"<span class='msg_time'>"+msg.time+"</span>"+
			"</div>");	
	}
	
	
}
$(document).ready(function(){
	
	connect();
	
	$('#action_menu_btn').click(function(){
		$('.action_menu').toggle();
	});
	
	$('#send').click(function(){
		if($('#message').val().length>=1)
		sendMessage();
	});
	$('#message').keypress(function(event){
	 	if(event.which===13)
	 	{
	 		$('#send').click();
	 	}
	});
});
