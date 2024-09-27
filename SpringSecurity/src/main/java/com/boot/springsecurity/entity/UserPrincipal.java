package com.boot.springsecurity.entity;

import java.util.Collection;
import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class UserPrincipal implements UserDetails{ //we have given the name UserPrinciple bcoz, in spring, we use the term Principle for current user
	
	private static final long serialVersionUID = 1L;
	
	@Autowired
	Users user;
	
	public UserPrincipal(Users user) {
		this.user=user;
	}
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return Collections.singleton(new SimpleGrantedAuthority("USER")); //As we have not added authorities column in Users DB, we are hardcoding the authorities; singleton bcoz of one particular object(USER).
	}

	@Override
	public String getPassword() {
		System.out.println("UserPrincipal getPassword() executed "+user.getPassword());
		return user.getPassword(); 
	}

	@Override
	public String getUsername() {
		System.out.println("UserPrincipal getUsername() executed "+user.getUsername());
		return user.getUsername();
	}

}
