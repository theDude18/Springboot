package com.karthi.spring.javaconfiguration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

public class Service {
	
	@Autowired
	Dao dao;
	
	Service(){
		System.out.println("object instantiated");
	}
	
	public void init() {
		System.out.println("init");
	}
	
	public void destroy() {
		System.out.println("destroy");
	}
	
	public void save() {
		dao.create();
	}

}
