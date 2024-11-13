package com.karthi.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
//import org.springframework.web.servlet.ModelAndView;

@Controller                      //like @Component(create a bean)
public class HelloController {
	
	@RequestMapping("/hello")                   //from web  hello comes and we are mapping here in this method to be called=
	public String hello(ModelMap map) {
		/* ModelAndView modelAndView=new ModelAndView();
		modelAndView.setViewName("hello");
		modelAndView.addObject("id",19);
		modelAndView.addObject("name","Manoj");
		modelAndView.addObject("salary",100000);   */
		map.addAttribute("id",18);
		map.addAttribute("name","karthi");
		map.addAttribute("salary",1000000);
		return "hello";	
	}
	
	@RequestMapping("/hai")
	public ModelAndView hai(){
		System.out.println("Avlothan");
		ModelAndView maV=new ModelAndView();
		maV.setViewName("hai");
		maV.addObject("name","Karthi");
		maV.addObject("id",18);
		return maV;
	}
}
