package com.karthi.springbootproj.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.karthi.springbootproj.models.DoctorInfo;
import com.karthi.springbootproj.models.PatientInfo;
import com.karthi.springbootproj.repos.DoctorRegistrationRepo;
import com.karthi.springbootproj.repos.PatientRegistrationRepo;

@Controller
@SessionAttributes("id")
public class RegisterController {
	
	@Autowired
	DoctorInfo docInfo;
	
	@Autowired
	PatientInfo patInfo;
	
	@Autowired
	PatientRegistrationRepo patRegRepo;
	
	@Autowired
	DoctorRegistrationRepo docRegRepo;
	
	@RequestMapping(value="userRegister1",method=RequestMethod.POST)
	public String userRegistered1(@RequestParam String firstName,String lastName,String dob,String gender,String contact,String userId,String password,String email,String userCategory,String nickname,String petname,String bornplace,ModelMap map) {
		if(userCategory.equals("doctor")) {
		docInfo.setFirstName(firstName);
		docInfo.setLastName(lastName);
		docInfo.setDob(dob);
		docInfo.setGender(gender);
		docInfo.setCotanct(contact);
		docInfo.setEmail(email);
		docInfo.setDoctorId(userId);
		docInfo.setPassword(password);
		docInfo.setNickname(nickname);
		docInfo.setPetname(petname);
		docInfo.setBornplace(bornplace);
		docRegRepo.save(docInfo);
		map.addAttribute("id",userId);
		//System.out.println(docInfo);
		return "userRegistrationSuccess";
		}
		else if(userCategory.equals("patient")){
			patInfo.setFirstName(firstName);
			patInfo.setLastName(lastName);
			patInfo.setDob(dob);
			patInfo.setGender(gender);
			patInfo.setCotanct(contact);
			patInfo.setEmail(email);
			patInfo.setPatientId(userId);
			patInfo.setPassword(password);
			patInfo.setNickname(nickname);
			patInfo.setPetname(petname);
			patInfo.setBornplace(bornplace);
			patRegRepo.save(patInfo);
			patRegRepo.save(patInfo);
			System.out.println(patInfo);
			map.addAttribute("id",userId);
			return "userRegistrationSuccess";
		}
		else {
		return "RegistrationFailed";
		}   
	}
}
