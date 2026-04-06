package com.quizApp.QuizApp.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.quizApp.QuizApp.Models.Attempt;
import com.quizApp.QuizApp.Models.Question;
import com.quizApp.QuizApp.Repositories.AttemptRepository;
import com.quizApp.QuizApp.Response.QuizResponse;

@Service
public class AttemptService {
    @Autowired
    private QuizService quizService ; 
    @Autowired
    private AttemptRepository attemptRepository ;
public ResponseEntity<String> SubmitQuiz(QuizResponse quizResponse) {
 String quizId = quizResponse.getQuizId();
String userId = quizResponse.getUserId();
if(attemptRepository.findByQuizId(quizId).stream().anyMatch(attempt -> attempt.getUserId().equals(userId))){
    return ResponseEntity.badRequest().body("You have already attempted this quiz.");
}
List<String> selectedAnswers = quizResponse.getSelectedAnswers();
List<Question> questions = quizService.getQuizById(quizId).getBody().getQuestions() ; 
 int score = 0 ; 
    for(int i = 0 ; i < questions.size() ; i++){
        if(questions.get(i).getCorrectAnswer().equals(selectedAnswers.get(i))){
            score++;
        }
    }
    Attempt attempt = new Attempt();
    attempt.setQuizId(quizId);
    attempt.setUserId(userId);
    attempt.setScore(score);
    attempt.setOutOf(questions.size());
    attemptRepository.save(attempt);
    return ResponseEntity.ok("Quiz submitted successfully. Your score is " + score + " out of " + questions.size());    
}
     public ResponseEntity<List<Attempt>>getAllResultsByUserId(String userId){
        return ResponseEntity.ok(attemptRepository.findByUserId(userId));
    }
   public ResponseEntity<List<Attempt>> getAllResult(String quizId){
      // return all the result in descending order of score 
        List<Attempt> attempts = attemptRepository.findByQuizId(quizId);
        attempts.sort((a, b) -> b.getScore().compareTo(a.getScore()));
        return ResponseEntity.ok(attempts);
    }
}
