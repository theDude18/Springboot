package com.karthi.springmvc.controller;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.karthi.springmvc.dto.Employee;

@Controller
public class ListController {
	
	@RequestMapping("/list")
	public ModelAndView list() {
		ModelAndView modelAndView=new ModelAndView();
		modelAndView.setViewName("list");
		
		Employee employee=new Employee();
		employee.setId(10);
		employee.setName("Sachin");
		employee.setSalary(100);
		
		Employee employee1=new Employee();
		employee1.setId(12);
		employee1.setName("Deepak Hooda");
		employee1.setSalary(50);
		
		Employee employee2=new Employee();
		employee2.setId(14);
		employee2.setName("Suryakumar Yadav");
		employee2.setSalary(70);
		
		ArrayList<Employee> emp=new ArrayList<Employee>();
		emp.add(employee);
		emp.add(employee1);
		emp.add(employee2);
		
		modelAndView.addObject("empo",emp);
		return modelAndView;
	}
}
