package com.boot.quizapp.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.boot.quizapp.dao.QuestionDao;
import com.boot.quizapp.model.Question;

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

}
