package com.quizApp.QuizApp.Models;
//this model help admin to create quiz and add question to it 

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
@Document(collection = "quizzes")
@Data
public class Quiz {
    @Id
    private String id ; 
    @NotBlank(message = "Title cannot be blank")
    private String title ; 
    @NotBlank(message = "Category cannot be blank")
    private String category ;
    private List<Question> questions ;
    
    private String createdBy ;
}
