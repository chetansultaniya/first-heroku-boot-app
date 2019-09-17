package com.internship2.demo1.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class HelloController {

	@RequestMapping("/")
	public String index()
	{
		return "Hello World";
	}
	
	@RequestMapping("/{s}")
	public String print(@PathVariable("s") String name)
	{
		return "Hello Welcome ! "+name;
	}
}
