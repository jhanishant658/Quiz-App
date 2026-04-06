package com.quizApp.QuizApp.Repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.quizApp.QuizApp.Models.Attempt;

@Repository
public interface AttemptRepository extends MongoRepository<Attempt, String> {

    List<Attempt> findByUserId(String userId);

    List<Attempt> findByQuizId(String quizId);

    
} 