package com.boot.jobapp.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.boot.jobapp.model.JobPost;
import com.boot.jobapp.repo.JobRepo;

@Service
public class JobService {

	@Autowired
	JobRepo jobRepo;
	
	public void addJob(JobPost jobPost){
		  jobRepo.addJob(jobPost);
	}
	
	public List<JobPost> getJobs(){
		return jobRepo.getJobs();
	}   
}
