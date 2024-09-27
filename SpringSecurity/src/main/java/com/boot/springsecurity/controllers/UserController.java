package com.boot.springsecurity.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.boot.springsecurity.entity.Users;
import com.boot.springsecurity.services.JwtService;
import com.boot.springsecurity.services.UserService;

@RestController
public class UserController {

	@Autowired
	UserService userService;
	
	@Autowired
	AuthenticationManager authenticationManager;
	
	@Autowired
	JwtService jwtService;
	
	@PostMapping("register")
	public Users registerUser(@RequestBody Users user) {
		userService.registerUser(user);
		return user;
	}
	
	@PostMapping("login")
	public String login(@RequestBody Users user) throws AuthenticationException {
		//AuthenticationManager ->AuthenticationProvider -> Authentication
		Authentication authentication=authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword()));
		if(authentication.isAuthenticated()) {
			return jwtService.getToken(user.getUsername()); 
		}
		else
			return "Login Failed";
	}
	
	@GetMapping("getUsers")
	public List<Users> getUsers() {
		return userService.getUsers();
	}
	
}