package com.karthi.springbootproj;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"com.karthi"})
//@EnableJpaRepositories({"com.karthi.springbootproj"})
public class DoctorPatientApplication {

	public static void main(String[] args) {
		SpringApplication.run(DoctorPatientApplication.class, args);
	}

}
