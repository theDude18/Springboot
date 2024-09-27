package com.boot.quizservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.boot.quizservice.model.QuestionWrapper;
import com.boot.quizservice.model.QuizDto;
import com.boot.quizservice.model.Response;
import com.boot.quizservice.service.QuizService;

@RestController
@RequestMapping("quiz")
public class QuizController {

	@Autowired
	QuizService quizService;
	
	@PostMapping("create")  
	public ResponseEntity<String> createQuiz(@RequestBody QuizDto quizDto) {
		return quizService.createQuiz(quizDto.getCategory(),quizDto.getNumOfQ(),quizDto.getTitle()); //title - title of quiz like JQuiz,JQuiz1,PQuiz etc..
	}
	
	@GetMapping("get/{id}")
	public ResponseEntity<List<QuestionWrapper>> getQuiz(@PathVariable Integer id){
		return quizService.getQuiz(id);
	}
	
	@PostMapping("submit")  
	public ResponseEntity<Integer> submitQuiz(@RequestBody List<Response> responses){ //when the user gets 3 questions, he needs to type the question id and response(right_answer) in the body and Post it. 		
		return quizService.calculateResult(responses);
	}
	
}
