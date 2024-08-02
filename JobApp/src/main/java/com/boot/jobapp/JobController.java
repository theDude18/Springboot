package com.boot.jobapp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.boot.jobapp.Service.JobService;
import com.boot.jobapp.model.JobPost;

@Controller
public class JobController {

	@Autowired
	JobService jobService;
	
	@GetMapping({"/","home"})  //we r setting for both '/' and 'home' in url's, so that even if we not give home in url, defaultly it will call the home page
	public String home() {
		return "home";
	}
	
	@GetMapping("addjob")
	public String addJob() {
		return "addjob";
	}
	
	@PostMapping("handleForm")    //Instead of '@RequestMapping(value="handleForm",method=RequestMethod.POST)',u can simply use 'PostMapping("handleForm")'
	public String handleForm(JobPost jobPost) {   //@ModelAttribute inside method parameter is not required. U can just give the Entity obj as u have already mentioned the 'modelAttribute' attribute in form tag in addjob.jsp 
		jobService.addJob(jobPost);
		return "success";
	}
	
	@GetMapping("viewalljobs")
	public String viewAllJobs(Model m) {
		List<JobPost> jobs=jobService.getJobs();
		m.addAttribute("jobPosts",jobs);
		return "viewalljobs";
	}
}




