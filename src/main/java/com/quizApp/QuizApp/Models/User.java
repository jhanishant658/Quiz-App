package com.quizApp.QuizApp.Models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
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
    @NotBlank(message = "Password cannot be blank")
    @Size(min = 6, message = "Password must be at least 6 characters long")
    private String password ; 
    private String role ; 
}
