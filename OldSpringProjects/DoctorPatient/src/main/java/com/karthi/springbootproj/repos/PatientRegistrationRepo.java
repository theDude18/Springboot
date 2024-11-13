package com.karthi.springbootproj.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.karthi.springbootproj.models.PatientInfo;

public interface PatientRegistrationRepo extends JpaRepository<PatientInfo,String>{

}
