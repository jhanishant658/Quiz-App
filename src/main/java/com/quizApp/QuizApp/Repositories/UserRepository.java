package com.quizApp.QuizApp.Repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.quizApp.QuizApp.Models.User;
@Repository
public interface UserRepository extends MongoRepository<User , String> {

    User findByEmail(String email);
    
}
