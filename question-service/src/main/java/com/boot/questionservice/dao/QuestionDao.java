package com.boot.questionservice.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.boot.questionservice.model.Question;

@Repository
public interface QuestionDao extends JpaRepository<Question,Integer>{
	
	public List<Question> findByCategory(String category); //Since category is a column in question table, JPA knows it and gives us the data based on category. Only when you have to do a lot of customization, you have to use @Query and write a query.
														   //While using JPA, you should use find and not get.(ie)For eg, findAll() and not getAll()

	@Query(value="SELECT q.id FROM question q WHERE q.category=:category ORDER BY RANDOM() LIMIT :numOfQ",nativeQuery=true) //':category' will fetch the argument category and give it in the query; RANDOM() function will fetch any 3 random questions from the question DB; LIMIT will make sure only the given no of ques is taken from question DB; this is not sql query, this is JPQL/HQL, thats why we have mentioned nativeQuery=true;
	public List<Integer> findRandomQuestionsByCategory(String category, int numOfQ);
	
	//@Query(value="SELECT * FROM question q WHERE q.id=:id",nativeQuery=true)
	//public Question findQuestionById(Integer id);
}

