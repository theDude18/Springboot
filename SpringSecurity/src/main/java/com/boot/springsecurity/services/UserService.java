package com.boot.springsecurity.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.boot.springsecurity.entity.Users;
import com.boot.springsecurity.repos.UserRepo;

@Service
public class UserService {

	@Autowired
	private UserRepo userRepo;
	
	private BCryptPasswordEncoder encoder=new BCryptPasswordEncoder(12); //12 is the strength of encoding it. 10 is the default strength. 12 means BCrypt will encode the password 2^12 times.
	
	public Users registerUser(Users user) {
		user.setPassword(encoder.encode(user.getPassword())); //when u register a new password, BCryptPasswordEncoder will encode the password and then save it in DB
		return userRepo.save(user);	
	}

	public List<Users> getUsers() {
		return userRepo.findAll();
	}
	
}
