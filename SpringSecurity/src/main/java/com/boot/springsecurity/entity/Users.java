package com.boot.springsecurity.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Users {        //In DB, first two rows are registered without BCryptPasswordEncoder. 

	@Id
	//@GeneratedValue(strategy = GenerationType.IDENTITY)   //to auto increment the id column
	private int id;
	private String username;
	private String password;
}
