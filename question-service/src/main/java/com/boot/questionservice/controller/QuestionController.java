package com.boot.questionservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.boot.questionservice.model.Question;
import com.boot.questionservice.model.QuestionWrapper;
import com.boot.questionservice.model.Response;
import com.boot.questionservice.service.QuestionService;



@RestController
@RequestMapping("question")
public class QuestionController {

	@Autowired
	QuestionService questionService;
	
	@Autowired
	Environment environment; //to check port number of instance
	
	@GetMapping("allQuestions")
	public ResponseEntity<List<Question>> getAllQuestions() {
		return questionService.getAllQuestions();
	}
	
	@GetMapping("category/{category}")
	public ResponseEntity<List<Question>> getQuestionsByCategory(@PathVariable String category){
		return questionService.getQuestionsByCategory(category);
	}
	
	@PostMapping("addQuestion")
	public ResponseEntity<Question> addQuestion(@RequestBody Question question) {
		return questionService.addQuestion(question);
	}
	
	@PutMapping("updateQuestion")
	public ResponseEntity<String> updateQuestion(@RequestBody Question question) {
		return questionService.updateQuestion(question);
	}
	
	@DeleteMapping("deleteMapping/{id}")
	public String deleteQuestion(@PathVariable int id) {
		return questionService.deleteQuestion(id);
	}
	
	
	//we will be generating the quiz questions id's in question-service itself bcoz all the questions are in Question DB and quiz-service can't access Question DB. It can only access question-service.
	//all the below 3 requests will com from quiz-service
	//generate - we will be generating only the requested no of question id's and sending those question id's in a Integer list.
	//getQuestions(questionId) - after generating the question id's, quiz-service will send request to get questions by sending question id's. Again, this will also be done in question-service as all the questions are in Question DB.
	//getScore - we will calculate the score in question-service as the right_answer is in Question DB.
	
	@GetMapping("generate")
	public ResponseEntity<List<Integer>> getQuestionsForQuiz( 
			@RequestParam String category,@RequestParam Integer numOfQ){  //We will generate the required no of questions'id(random) and send those ques id's in a integer list and also it returns only the question id's list and not the question itself
		return questionService.getQuestionsForQuiz(category,numOfQ);
	}
	
	@PostMapping("getQuestion")
	public ResponseEntity<List<QuestionWrapper>> getQuestionsById(@RequestBody List<Integer> questionIds){ //in this method, we will return the questions of the question id's sent by the quiz-service
		System.out.println(environment.getProperty("local.server.port"));  //to check which instance port number is getting called
		return questionService.getQuestionsById(questionIds);
	}
	
	@PostMapping("getScore")
	public ResponseEntity<Integer> getScore(@RequestBody List<Response> responses){
		return questionService.getScore(responses);
	}
}
