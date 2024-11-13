package com.karthi.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.karthi.springmvc.dto.UserModel;

@Controller
public class UserController {
	
	@RequestMapping("/registrationPage")    
	public ModelAndView regPage() {            //First method to redirect to registration html page
		ModelAndView maV=new ModelAndView();
		maV.setViewName("UserRegistrationPage");
		return maV;
	}	
	
	@RequestMapping(value="regPage",method=RequestMethod.POST)      //@RequestMapping("/regPage"). This is also correct
	public String regPage1(@ModelAttribute("user") UserModel user,ModelMap map){       //Second method to get the details entered in the html reg page 
		//ModelAndView maV=new ModelAndView();
		map.addAttribute("usermap",user);       //The object in the regPage1 method
		System.out.println(user);
		//maV.setViewName("RegPageResult");
		return "RegPageResult";
	}
	
	@RequestMapping("/paramRegPage")
	public ModelAndView regPage2(@RequestParam(value="id",required=false,defaultValue="7")int id,@RequestParam("name")String name,@RequestParam(value="salary",required=false,defaultValue="200")int salary) {
		ModelAndView maV=new ModelAndView();
		System.out.println(id);
		System.out.println(name);
		System.out.println(salary);
		maV.setViewName("RegPageResult");
		return maV;
	}
}
