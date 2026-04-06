package com.quizApp.QuizApp.Models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Document(collection = "attempts")
@Data
public class Attempt {
    //this model is for user to attempt quiz and save his score and time of submission
    @Id
    private String id;
    private String userId;
    private String quizId;
    private Integer score;
    private Integer outOf ; 
    
}
