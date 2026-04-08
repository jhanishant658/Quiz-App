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

import com.quizApp.QuizApp.Models.Attempt;
import com.quizApp.QuizApp.Response.QuizResponse;
import com.quizApp.QuizApp.Services.AttemptService;

@RestController
@RequestMapping("/api/attempts")
public class AttemptController {
@Autowired
private AttemptService attemptService ;
 @PostMapping("/submit")
    public ResponseEntity<String> submitAttempt(@RequestBody QuizResponse quizResponse) {
        return attemptService.SubmitQuiz(quizResponse) ;
    }
@GetMapping("/userResults")
    public ResponseEntity<List<Attempt>> getAllResultsByUserId(@RequestParam String userId) {
        return attemptService.getAllResultsByUserId(userId) ;
    }
@GetMapping("/leaderboard")
    public ResponseEntity<List<Attempt>> getAllResult(@RequestParam String quizId) {
        return attemptService.getAllResult(quizId) ;
    }
    
}