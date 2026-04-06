package com.quizApp.QuizApp.Repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.quizApp.QuizApp.Models.Question;

public interface QuestionRepository extends MongoRepository<Question,String> {

    List<Question> findByCategory(String category);
    
}
