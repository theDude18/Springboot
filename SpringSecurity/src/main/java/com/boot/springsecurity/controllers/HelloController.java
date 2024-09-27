package com.boot.springsecurity.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpServletRequest;

@RestController
public class HelloController {

	@GetMapping({"/","hello"})
	public String hello(HttpServletRequest req) {
		return "Hello Controller "+ req.getSession().getId();  //just for learning purpose, checking the session id
	}
	
	@GetMapping("name")
	public String name(HttpServletRequest req) {
		return "Karthi " + req.getSession().getId();
	}
	
	
}
