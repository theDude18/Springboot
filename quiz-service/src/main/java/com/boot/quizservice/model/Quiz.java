package com.boot.quizservice.model;

import java.util.List;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Quiz {  //remember for quiz-service, we are using diff DB called quizdb and not mydb.

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String title;
	
	@ElementCollection   //Here @ManytoMany will not come as we are not connecting with a table column. We are just going to get list of numbers, so DB provides us with @ElementCollection to collect a list of a specific datatype values.This will also act like @ManytoMany (i.e)creates another table with columns quizId and questionIds. 
	private List<Integer> questionsIds; //We are going to get only questionId's here.
}
