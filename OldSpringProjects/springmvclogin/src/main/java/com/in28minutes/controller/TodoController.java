package com.in28minutes.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.in28minutes.nadunisi.TodoService;

@Controller
public class TodoController {
	
	@Autowired
	TodoService todoService;
	
	@RequestMapping(value="/todo-list",method=RequestMethod.GET)
	public String showTodoList(ModelMap map) {
		map.put("todos",todoService.retrieveTodos("in28Minutes"));  //giving username in parameter so that if it aleady exists in the list it will return that ref obj as list
		return "todo-list";
	}
	
	@RequestMapping(value="add-todo",method=RequestMethod.GET)
	public String gotoAddTodo() {
		return "add-todo";
	}
	
	@RequestMapping(value="add-todo",method=RequestMethod.POST)
	public String addingTodo(@RequestParam String desc,ModelMap map) {
		todoService.addTodo("in28Minutes",desc,new Date(),false);
		map.clear();                        //it wont allow to show any info in the url. Increases security.
		return "redirect:todo-list";        //It redirects to @RequestMapping(value="/todo-list",method=RequestMethod.GET) bcoz if u give "todo-list" in return it will go to todo-list.jsp.
	}
	
	
	
}
