package com.boot.springdatarest.model;

import java.util.List;

import org.springframework.stereotype.Component;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data // provides getters,setters,toString,hashCode methods for all the variables
@NoArgsConstructor // default Constructor
@AllArgsConstructor // Constructor with all the Parameters
//@Component  //this is important to let the proj know of this model class and make it accessible from other classes or views
@Entity
@Table
public class JobPost {
	@Id
	private int postId;
	private String postProfile;
	private String postDesc;
	private int reqExperience;
	private List<String> postTechStack;
	
}
