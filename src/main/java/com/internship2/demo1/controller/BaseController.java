package com.internship2.demo1.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.internship2.demo1.model.ContactUs;
import com.internship2.demo1.model.UserResponse;
import com.internship2.demo1.model.api.Response;
import com.internship2.demo1.service.ContactUsService;

import static com.internship2.demo1.model.UserResponse.GroupType.*;
import static com.internship2.demo1.model.UserResponse.MessageType.*;
import static com.internship2.demo1.constant.ApplicationConstants.*;

@Controller
public class BaseController {
	
	@Autowired
	ContactUsService contactUsService;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Map<String, Object> model)
	{
		model.put("app_name", APP_NAME);
		return "index";
	}
	
	@RequestMapping(value = "/chatpage", method = RequestMethod.POST)
	public String openChatPage(Map<String,Object> model, @RequestParam String key, @RequestParam String name)
	{
		model.put("key", key);
		model.put("name", name);
		
		return "chatpage";
	}
	
	@PostMapping(path="contactUs/save",consumes = "application/json")
	public @ResponseBody ResponseEntity<Response> save(@RequestBody ContactUs contactUs)
	{
		return new ResponseEntity<>(contactUsService.save(contactUs), HttpStatus.OK) ;
	}
	
	@GetMapping("contactUs/getAll")
	public @ResponseBody ResponseEntity<List<ContactUs>> getAll()
	{
		return new ResponseEntity<>(contactUsService.getAll(),HttpStatus.OK);
	}
	
	@MessageMapping("{groupid}/connect")
	@SendTo("/queue/{groupid}/connect")
	public UserResponse connect(@DestinationVariable String groupid, @RequestParam String username,
			SimpMessageHeaderAccessor headerAccessor) {
		headerAccessor.getSessionAttributes().put("username", username);
		headerAccessor.getSessionAttributes().put("key", groupid);
		UserResponse userResponse = new UserResponse(username, NEW_USER_JOINED, JOIN, PRIVATE);
		return userResponse;
	}

	@MessageMapping("{groupid}/message")
	@SendTo("/queue/{groupid}/message")
	public UserResponse getMessage(@DestinationVariable String groupid, @Payload UserResponse userResponse) {

		userResponse.setMtype(CHAT);
		userResponse.setGtype(PRIVATE);
		//"hh" in pattern is for 12 hour time format and "aa" is for AM/PM
		SimpleDateFormat dateTimeInGMT = new SimpleDateFormat("yyyy-MMM-dd hh:mm aa");
		//Setting the time zone
		dateTimeInGMT.setTimeZone(TimeZone.getTimeZone("GMT"));
		System.out.println(dateTimeInGMT.format(new Date()));
		
		//userResponse.setTime(valueOf(now()));
		
		userResponse.setTime(dateTimeInGMT.format(new Date()));
		
		return userResponse;
	}
}
