package com.boot.quizservice.service;

import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

//import com.boot.quizservice.dao.QuestionDao;
import com.boot.quizservice.dao.QuizDao;
import com.boot.quizservice.feign.QuizInterface;
import com.boot.quizservice.model.QuestionWrapper;
import com.boot.quizservice.model.Quiz;
import com.boot.quizservice.model.Response;

@Service
public class QuizService {

	@Autowired
	QuizDao quizDao;
	
	@Autowired
	QuizInterface quizInterface;

	public ResponseEntity<String> createQuiz(String category, int numOfQ, String title) {
		
		List<Integer> questionIds=quizInterface.getQuestionsForQuiz(category, numOfQ).getBody(); //using getBody(), bcoz in question-service's getQuestionsForQuiz() we are returning in ResponseEntity<> form. We only need the List of integers and not the HttpStatus.
		Quiz quiz=new Quiz();
		quiz.setTitle(title);
		quiz.setQuestionsIds(questionIds);
		quizDao.save(quiz);
		
		return new ResponseEntity<>("Quiz created successfully",HttpStatus.CREATED);
	}

	public ResponseEntity<List<QuestionWrapper>> getQuiz(Integer id) {
		Quiz quiz=quizDao.findById(id).get();
		List<Integer> questionIds=quiz.getQuestionsIds();
		ResponseEntity<List<QuestionWrapper>> questionsForUser=quizInterface.getQuestionsById(questionIds); //quizInterface.getQuestionsById() method returns not just List<QuestionWrapper>, but ResponseEntity<List<QuestionWrapper>>. So, both the body and 
		return questionsForUser; //since you are getting questionsForUser in the form of ResponseEntity<> in the above line, you can just return questionsForUser. It contains the HttpStatus with itself.
	}

	public ResponseEntity<Integer> calculateResult(List<Response> responses) {
		ResponseEntity<Integer> score=quizInterface.getScore(responses);
		return score;
	}
	
}
