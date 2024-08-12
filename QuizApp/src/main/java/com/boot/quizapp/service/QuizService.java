package com.boot.quizapp.service;

import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.boot.quizapp.dao.QuestionDao;
import com.boot.quizapp.dao.QuizDao;
import com.boot.quizapp.model.Question;
import com.boot.quizapp.model.QuestionWrapper;
import com.boot.quizapp.model.Quiz;
import com.boot.quizapp.model.Response;

@Service
public class QuizService {

	@Autowired
	QuizDao quizDao;
	
	@Autowired
	QuestionDao questionDao;

	public ResponseEntity<String> createQuiz(String category, int numOfQ, String title) {
		
		List<Question> questions=questionDao.findRandomQuestionsByCategory(category,numOfQ);
		Quiz quiz=new Quiz();
		quiz.setTitle(title);
		quiz.setQuestions(questions);
		
		quizDao.save(quiz);
		
		return new ResponseEntity<>("Quiz created successfully",HttpStatus.CREATED);
	}

	public ResponseEntity<List<QuestionWrapper>> getQuiz(int id) {
		Optional<Quiz> quiz=quizDao.findById(id); //Using Optional<> bcoz the passed id may not be present in DB. So we shld to use Optional<> to handle the exception.
		List<Question> questionsFromDB=quiz.get().getQuestions(); //get() is used bcoz we created the quiz reference obj in Optional<Quiz> in previous line; this getQuestions() will give entire question row. But we need only id,question title & 4 options.
		List<QuestionWrapper> questionsForUser=new ArrayList<>();
		for(Question q:questionsFromDB) {
			QuestionWrapper questionForUser=new QuestionWrapper(q.getId(),q.getQuestionTitle(),q.getOption1(),q.getOption2(),q.getOption3(),q.getOption4());
			questionsForUser.add(questionForUser);
		}
		return new ResponseEntity<>(questionsForUser,HttpStatus.OK);
	}

	public ResponseEntity<Integer> calculateResult(Integer id,List<Response> responses) {
		Optional<Quiz> quiz=quizDao.findById(id);
		List<Question> questionsInQuiz=quiz.get().getQuestions();
		int i=0,right=0;
		for(Response response:responses) {
			if(response.getResponse().equals(questionsInQuiz.get(i).getRightAnswer())) { //questionInQuiz.get(i).getRightAnswer == question.getRightAnswer;
				right++;
			}
			i++;
		}
		return new ResponseEntity<>(right,HttpStatus.OK);
	}
	
}
