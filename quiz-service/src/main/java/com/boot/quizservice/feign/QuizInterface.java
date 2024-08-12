package com.boot.quizservice.feign;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.boot.quizservice.model.QuestionWrapper;
import com.boot.quizservice.model.Response;



@FeignClient("QUESTION-SERVICE")
public interface QuizInterface {
	
	@GetMapping("question/generate")  //Here, dont forget to add "question" in url. We have given "question" in the RequestMapping of class QuestionController of question-service.
	public ResponseEntity<List<Integer>> getQuestionsForQuiz(@RequestParam String category,@RequestParam Integer numOfQ); //We will generate the required no of questions'id(random) and send those ques id's in a integer list and also it returns only the question id's list and not the question itself
	
	@PostMapping("question/getQuestion")
	public ResponseEntity<List<QuestionWrapper>> getQuestionsById(@RequestBody List<Integer> questionIds); //in this method, we will return the questions of the question id's sent by the quiz-service
	
	@PostMapping("question/getScore")
	public ResponseEntity<Integer> getScore(@RequestBody List<Response> responses);
}
