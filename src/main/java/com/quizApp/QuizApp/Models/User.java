package com.quizApp.QuizApp.Models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import jakarta.validation.constraints.Email;
import lombok.Data;

@Document(collection = "users")
@Data
public class User {
   @Id
private String userId;

@Indexed(unique = true)
    @Email(message = "Email should be valid")
    private String email ; 
    private String name ; 
    private String password ; 
    private String role ; 
}
