package com.boot.jobapp.model;

import java.util.List;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data // provides getters,setters,toString,hashCode methods for all the variables
@NoArgsConstructor // default Constructor
@AllArgsConstructor // Constructor with all the Parameters
@Component  //this is important to let the proj know of this model class and make it accessible from other classes or views
public class JobPost {

	private int postId;
	private String postProfile;
	private String postDesc;
	private int reqExperience;
	private List<String> postTechStack;
	
}
