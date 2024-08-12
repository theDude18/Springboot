package com.boot.quizapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.boot.quizapp.model.QuestionWrapper;
import com.boot.quizapp.model.Response;
import com.boot.quizapp.service.QuizService;

@RestController
@RequestMapping("quiz")
public class QuizController {

	@Autowired
	QuizService quizService;
	
	@PostMapping("create")  //http://localhost:8181/quiz/create?category=Java&numOfQ=3&title=JQuiz
	public ResponseEntity<String> createQuiz(@RequestParam String category,@RequestParam int numOfQ,@RequestParam String title) {
		return quizService.createQuiz(category,numOfQ,title);
	}
	
	@GetMapping("get/{id}")
	public ResponseEntity<List<QuestionWrapper>> getQuiz(@PathVariable int id){
		return quizService.getQuiz(id);
	}
	
	@PostMapping("submit/{id}")  //id is quiz id
	public ResponseEntity<Integer> submitQuiz(@PathVariable Integer id, @RequestBody List<Response> responses){ //when the user gets 3 questions, he needs to type the question id and response(right_answer) in the body and Post it. 
		//purpose of the method is to get the response and check it and calculate the score and send it to the client.
		//We have to get the answers and check it with the right_answers and send the score back.
		
		return quizService.calculateResult(id,responses);
	}
	
}
