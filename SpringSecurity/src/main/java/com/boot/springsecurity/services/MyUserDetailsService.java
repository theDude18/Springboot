package com.boot.springsecurity.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.boot.springsecurity.entity.UserPrincipal;
import com.boot.springsecurity.entity.Users;
import com.boot.springsecurity.repos.UserRepo;

@Service
public class MyUserDetailsService implements UserDetailsService{

	@Autowired
	UserRepo userRepo; // UserRepo is needed to fetch credentials info from DB and give to 'loadUserByUserName' method here
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException { //this method will return the entire row of user, by checking the username we pass here.
		
		Users user=userRepo.findByUsername(username);  //fetches the row of given uname and assigns it to obj user of Users entity class
		if(user==null) {  //if uname is not present
			System.out.println("404 not found");
			throw new UsernameNotFoundException("Username doesn't exist");
		}
		System.out.println(user);
		return new UserPrincipal(user);  // this will go to UserPrincipal class's constructor & we are passing user obj. since we are instantiating the UserPrincipal class in return statement, it will call the constructor and also all the methods & will return the authorities,uname &pswrd.
										 //	This return will return the uname,pswrd and authorities taken from DB & return to the . UserPrincipal is the implementation class of UserDetails.
	}

}
