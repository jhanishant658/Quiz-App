package com.quizApp.QuizApp.Services;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.quizApp.QuizApp.Models.Question;
import com.quizApp.QuizApp.Models.Quiz;
import com.quizApp.QuizApp.Repositories.QuizRepository;

public class QuizService {
    @Autowired
    private QuizRepository quizRepository ;
    @Autowired
    private QuestionService questionService ;
    public ResponseEntity<String> createQuiz(String category , String title , int numOfQuestions , String createdBy){
        
     List<Question> allQuestions = questionService.getQuestionByCategory(category).getBody();
     Collections.shuffle(allQuestions);
     List<Question> questions = allQuestions.stream().limit(numOfQuestions).toList();
     if(questions.size() < numOfQuestions){
        return new ResponseEntity<>("Not enough questions available in the selected category", HttpStatus.BAD_REQUEST);
     }
     Quiz quiz = new Quiz();
        quiz.setTitle(title);
        quiz.setCategory(category);
        quiz.setQuestions(questions);
        quiz.setCreatedBy(createdBy);
        quizRepository.save(quiz);
        return new ResponseEntity<>("Quiz created successfully", HttpStatus.CREATED);
    }   
    public ResponseEntity<String> createYourOwnQuiz(Quiz quiz){
        quizRepository.save(quiz);
        return new ResponseEntity<>("Quiz created successfully", HttpStatus.CREATED);
    }
    public ResponseEntity<List<Quiz>> getAllQuizzes(){
        return new ResponseEntity<>(quizRepository.findAll(), HttpStatus.OK);
    }
     public ResponseEntity<List<Quiz>> getAllQuizzesByCategory(String category){
        return new ResponseEntity<>(quizRepository.findByCategory(category), HttpStatus.OK);
    }
    public ResponseEntity<Quiz> getQuizById(String id){
        return new ResponseEntity<>(quizRepository.findById(id).orElse(null), HttpStatus.OK);
    }
   
}
