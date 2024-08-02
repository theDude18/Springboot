package com.boot.springdatarest.repo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.boot.springdatarest.model.JobPost;

@Repository
public interface JobRepo extends JpaRepository<JobPost, Integer> { 

	//For Spring Data Rest, only Repository and Model class is needed. It will automatically takes care of all the http functions. Give the endpoint in Http request path as Model class name in plural and in camelCase(jobPosts).                       
	//Just we need to change the methods in postman. Endpoint(jobPosts) will be same for all core methods like POST,GET,PUT,DELETE etc..
}
