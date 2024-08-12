package com.boot.quizapp.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class QuestionWrapper {

	private Integer id;
	private String questionTitle; //In DB, this column will be question_title. This type of declaring variable is called snake case. But JPA will automatically convert it into camel case as questionTitle.
	private String option1;
	private String option2;
	private String option3;
	private String option4;
}
