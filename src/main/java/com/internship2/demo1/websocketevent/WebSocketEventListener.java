package com.internship2.demo1.websocketevent;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.messaging.simp.stomp.StompHeaderAccessor;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.messaging.SessionConnectEvent;
import org.springframework.web.socket.messaging.SessionDisconnectEvent;

import com.internship2.demo1.model.UserResponse;

import static com.internship2.demo1.model.UserResponse.MessageType.*;
import static com.internship2.demo1.model.UserResponse.GroupType.*;
import static com.internship2.demo1.constant.ApplicationConstants.*;


@Component
public class WebSocketEventListener {

	@Autowired
	SimpMessagingTemplate simpMessagingTemplate;
	
	@EventListener(SessionConnectEvent.class)
	public void handleWebsocketConnectListener(SessionConnectEvent event) {
		System.out.println("SessionConnectEvent");
	}
	
	@EventListener(SessionDisconnectEvent.class)
	public void handleWebsocketDisconnectListener(SessionDisconnectEvent event) {
		System.out.println("SessionDisconnectEvent");
		SimpMessageHeaderAccessor headerAccessor = StompHeaderAccessor.wrap(event.getMessage());
		String username = (String) headerAccessor.getSessionAttributes().get("username");
		String key = (String) headerAccessor.getSessionAttributes().get("key");

		if (username != null&& key != null) {

			UserResponse userResponse = new UserResponse(username, USER_LEFT, LEAVE, PUBLIC);
			simpMessagingTemplate.convertAndSend("/queue/"+key+"/connect", userResponse);

		}
	}

}
