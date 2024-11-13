package com.karthi.springbootproj.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

	@RequestMapping("/home")
	public String home() {
		return "home";
	}
	
	@RequestMapping("/user")
	public String user() {
		return "user";
	}
	
	@RequestMapping("/userlogin")
	public String userlogin() {
		return "userlogin";
	}
	
	@RequestMapping("/userregister")
	public String userregister(){
		return "userregister";
	}

}
