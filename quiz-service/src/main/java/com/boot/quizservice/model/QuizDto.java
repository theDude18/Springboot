package com.boot.quizservice.model;

import lombok.Data;

@Data
public class QuizDto {

	private String category;
	private Integer numOfQ;
	private String title;
}
