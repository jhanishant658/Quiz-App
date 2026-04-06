package com.quizApp.QuizApp.Repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import org.springframework.stereotype.Repository;

import com.quizApp.QuizApp.Models.Quiz;

@Repository
public interface QuizRepository extends MongoRepository<Quiz, String>{

    List<Quiz> findByCategory(String category);
    
   
    
}
