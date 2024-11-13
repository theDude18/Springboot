package com.in28minutes.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.in28minutes.nadunisi.LoginService;

@Controller
public class LoginController {
	
	@Autowired
	LoginService service;
	
	@RequestMapping(value="/login",method=RequestMethod.GET)
	public String login() {
		return "login";
	}
	
	@RequestMapping(value="/login",method=RequestMethod.POST)
	public String welcome(@RequestParam String name,String password,ModelMap map) {
		if(service.validate(name,password)==false) {
			map.put("errorMessage","Invalid Userid");
			return "login";
		}
		map.put("name",name);
		map.put("password",password);
		return "welcome";
	}
}
