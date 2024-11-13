package com.in28minutes.nadunisi;

import org.springframework.stereotype.Service;

@Service
public class LoginService {

	public boolean validate(String uname,String password) {
		if(uname.equalsIgnoreCase("2126306")&&password.equals("karthi18")) 
			return true;
		else
			return false;
	}
}
