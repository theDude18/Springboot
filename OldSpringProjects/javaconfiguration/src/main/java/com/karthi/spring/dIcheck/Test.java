package com.karthi.spring.dIcheck;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
	public static void main(String arg[]) {
		ApplicationContext context=new ClassPathXmlApplicationContext("com/karthi/spring/dIcheck/config.xml");
		Service service=(Service)context.getBean("service");
		service.save();		
	}
}
