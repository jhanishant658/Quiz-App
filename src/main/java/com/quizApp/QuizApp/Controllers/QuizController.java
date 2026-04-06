package com.quizApp.QuizApp.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.quizApp.QuizApp.Models.Quiz;
import com.quizApp.QuizApp.Services.QuizService;

@RestController
@RequestMapping("/api/quizzes")
public class QuizController {
 @Autowired 
 private QuizService quizService ;
    @PostMapping("/create")
    public ResponseEntity<String >createQuiz(@RequestParam String category , @RequestParam String title , @RequestParam int numOfQuestions , @RequestParam String createdBy) {
         try {
           return quizService.createQuiz(category, title, numOfQuestions, createdBy) ;
        } catch (Exception e) {
           e.printStackTrace();
            return ResponseEntity.status(500).build();
        }
        
    }
    @PostMapping("/createYourOwn")
    public ResponseEntity<String >createYourOwnQuiz(@RequestBody Quiz quiz) {
        try {
            return quizService.createYourOwnQuiz(quiz) ;
        } catch (Exception e) {
           e.printStackTrace();
            return ResponseEntity.status(500).build();
        }
        
    }
    @GetMapping("/all")
    public ResponseEntity<List<Quiz>> getAllQuizzes() {
        try {
            return quizService.getAllQuizzes();
        } catch (Exception e) {
           e.printStackTrace();
            return ResponseEntity.status(500).build();
        }
    }
    @GetMapping("/category")
    public ResponseEntity<List<Quiz>> getAllQuizzesByCategory(@RequestParam String category) {
        try {
            return quizService.getAllQuizzesByCategory(category);
        } catch (Exception e) {
           e.printStackTrace();
            return ResponseEntity.status(500).build();
        }
    }
    @GetMapping("/id")
    public ResponseEntity<Quiz> getQuizById(@RequestParam String id) {
        try {
            return quizService.getQuizById(id);
        } catch (Exception e) {
           e.printStackTrace();
            return ResponseEntity.status(500).build();
        }
    }
}