package com.quizApp.QuizApp.Response;

import java.util.List;

import lombok.Data;

@Data
public class QuizResponse {
     private String quizId ; 
     private String userId ; 
     private List<String> selectedAnswers ;

}
