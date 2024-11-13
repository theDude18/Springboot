package com.karthi.springbootproj.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.karthi.springbootproj.models.DoctorInfo;

public interface DoctorRegistrationRepo extends JpaRepository<DoctorInfo,String> {

}
