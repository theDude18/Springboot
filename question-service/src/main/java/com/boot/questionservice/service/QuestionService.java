package com.boot.questionservice.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.boot.questionservice.dao.QuestionDao;
import com.boot.questionservice.model.Question;
import com.boot.questionservice.model.QuestionWrapper;
import com.boot.questionservice.model.Response;

@Service
public class QuestionService {

	@Autowired
	QuestionDao questionDao;
	
	public ResponseEntity<List<Question>> getAllQuestions() { //ResponseEntity<> is a class which we can use to send the HTTP response status code along with the data; Inside angular brackets, mention the datatype.
		try {
			return new ResponseEntity<>(questionDao.findAll(),HttpStatus.OK); //In ResponseEntity constructor, we are passing the data and HTTP response status code in 1st & 2nd arguments.
		}catch(Exception e){
			e.printStackTrace();
		}
		return new ResponseEntity<>(new ArrayList<>(),HttpStatus.BAD_REQUEST); //If there is an error in return stmt inside try block, then it will catch it and the catch block will get executed and then this return statement also will get executed.
	}

	public ResponseEntity<List<Question>> getQuestionsByCategory(String category) {
		try {
		return new ResponseEntity<>(questionDao.findByCategory(category),HttpStatus.OK);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<>(new ArrayList<>(),HttpStatus.BAD_REQUEST);
	}

	public ResponseEntity<Question> addQuestion(Question question) {
		return new ResponseEntity<>(questionDao.save(question),HttpStatus.CREATED);
	}

	public ResponseEntity<String> updateQuestion(Question question) {
		questionDao.save(question);
		return new ResponseEntity<>("Updated Successfully",HttpStatus.CREATED);
	}
	
	public String deleteQuestion(int id) {
		questionDao.deleteById(id);
		return "Deleted Successfully";
	}

	public ResponseEntity<List<Integer>> getQuestionsForQuiz(String category, Integer numOfQ) {
		List<Integer> questionIds=questionDao.findRandomQuestionsByCategory(category,numOfQ);
		return new ResponseEntity<>(questionIds,HttpStatus.OK);
	}

	public ResponseEntity<List<QuestionWrapper>> getQuestionsById(List<Integer> questionIds) {
		
		List<Question> questionsFromDB=new ArrayList<>();
		for(int qID:questionIds) {
			questionsFromDB.add(questionDao.findById(qID).get());
		}
		
		List<QuestionWrapper> questionsForUser=new ArrayList<>();
		for(Question q:questionsFromDB) {
			QuestionWrapper questionForUser=new QuestionWrapper(q.getId(),q.getQuestionTitle(),q.getOption1(),q.getOption2(),q.getOption3(),q.getOption4());
			questionsForUser.add(questionForUser);
		}
		return new ResponseEntity<>(questionsForUser,HttpStatus.OK);
	}

	public ResponseEntity<Integer> getScore(List<Response> responses) {
		int i,right=0;
		//Question question=questionDao.getById()
		for(Response response:responses) {
			if(response.getResponse().equals((questionDao.findById(response.getId()).get()).getRightAnswer())) { //comparing the given response and rightAnswer of that Question(by using responseID, we will fetch the question); get() is used to handle the exception instead of Optional<>. While using getById(), there might be a chance that the given id not present in DB. So it will give error and we have to handle it using Optional<> or get(). But using Optional<> is the best way. 
				right++;
			}
		}
		return new ResponseEntity<>(right,HttpStatus.OK);
	}

}
