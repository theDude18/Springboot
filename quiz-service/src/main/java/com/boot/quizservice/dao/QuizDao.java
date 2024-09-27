package com.boot.quizservice.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.boot.quizservice.model.Quiz;

@Repository
public interface QuizDao extends JpaRepository<Quiz,Integer>{

}
