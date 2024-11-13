package com.in28minutes.nadunisi;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;


import org.springframework.stereotype.Service;

@Service
public class TodoService {

	private static List<Todo> todos = new ArrayList<Todo>();    //Instead of using DB we r using List to perform add delete and get functions for understanding. todos is the list used here n all functions will be applied in the todos.
	private static int todoCount = 3;

	static {                     
		todos.add(new Todo(1, "in28Minutes", "Learn Spring MVC", new Date(), false));  //Since List is created static constructor is used in this line to pre-add the list without instantiating object
		todos.add(new Todo(2, "in28Minutes", "Learn Struts", new Date(), false));  //Here new Date() return current date and time(inbuilt class)
		todos.add(new Todo(3, "in28Minutes", "Learn Hibernate", new Date(), false));
	}

	public void addTodo(String name, String desc, Date targetDate, boolean isDone) {  //Add function in DB
		todos.add(new Todo(++todoCount, name, desc, targetDate, isDone));
	}

	public List<Todo> retrieveTodos(String user) {           //get function in DB. Just watch clearly this code it is understandable
		List<Todo> filteredTodos = new ArrayList<Todo>();
		for (Todo todo : todos) {
			if (todo.getUser().equals(user))
				filteredTodos.add(todo);
		}
		return filteredTodos;
	}
	
	public void deleteTodo(int id) {                     //delete func in DB. Understandable code.
		Iterator<Todo> iterator = todos.iterator();
		while (iterator.hasNext()) {
			Todo todo = iterator.next();
			if (todo.getId() == id) {
				iterator.remove();
			}
		}
	}
}
