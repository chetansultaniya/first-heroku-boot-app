package com.internship2.demo1.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/display")
public class DisplayController {

	@RequestMapping("/login")
	public ModelAndView name()
	{
		ModelAndView mv = new ModelAndView("login");
		
		return mv;
	}
	
	@RequestMapping("/signup")
	public ModelAndView signup()
	{
		ModelAndView mv = new ModelAndView("signup");
		return mv;
	}
}
