package com.karthi.springmvcorm.user.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.karthi.springmvcorm.user.dao.services.UserService;
import com.karthi.springmvcorm.user.entity.User;

@Controller
public class UserController {
	
	@Autowired
	UserService service;

	public UserService getService() {
		return service;
	}

	public void setService(UserService service) {
		this.service = service;
	}
	
	@RequestMapping("registrationPage")
	public String regPage() {
		return "userReg";
	}
	
	@RequestMapping(value="registeredPage",method=RequestMethod.POST)
	public String regPage1(@ModelAttribute("user") User user,ModelMap map) {
		int res=service.save(user);
		map.addAttribute("user","User created with Id"+user);
		map.addAttribute("res",res);
		return "userReg";
	}
	
	@RequestMapping("display")
	public String display(ModelMap map) {
		List<User> user=service.showAll();
		map.addAttribute("user",user);
		return "displayPage";
	}
	
	@RequestMapping("checkId")
	public @ResponseBody String check(@RequestParam("id") int id) {
		User user=service.checkId(id);
		String msg="";
		if(user!=null)
			msg=id+" already exists";
		return msg;
	}
}
