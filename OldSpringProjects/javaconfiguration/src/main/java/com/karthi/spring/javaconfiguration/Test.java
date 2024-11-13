package com.karthi.spring.javaconfiguration;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test {
	public static void main(String arg[]) {
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext(SpringConfig.class);
		Service service=context.getBean(Service.class);
		Service s1=context.getBean(Service.class);
		service.save();
		s1.save();
		System.out.println(service.hashCode());
		System.out.println(s1.hashCode());
		context.close();
	}
}
