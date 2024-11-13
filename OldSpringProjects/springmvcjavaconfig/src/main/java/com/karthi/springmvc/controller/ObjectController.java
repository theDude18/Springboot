package com.karthi.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.karthi.springmvc.dto.Employee;

@Controller
public class ObjectController {
	
	@RequestMapping("/viewObject")
	public ModelAndView objectDetails() {
		ModelAndView modelAndView=new ModelAndView();
		modelAndView.setViewName("object");
		Employee employee=new Employee();
		employee.setId(18);
		employee.setName("Karthi");
		employee.setSalary(260000);
		modelAndView.addObject("emp",employee);
		return modelAndView;
	}
}
