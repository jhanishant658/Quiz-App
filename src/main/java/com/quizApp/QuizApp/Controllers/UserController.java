package com.quizApp.QuizApp.Controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.quizApp.QuizApp.Models.User;
import com.quizApp.QuizApp.Request.LoginReq;
import com.quizApp.QuizApp.Services.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping("/api/users")
public class UserController {
    @Autowired
    private UserService userService ;
    @PostMapping("/register")
    public String registerUser(@RequestBody User user) {
        return userService.registerUser(user) ;
    }
    @PostMapping("/login")
    public String LoginUser(@RequestBody LoginReq req) {
        return userService.LoginUser(req) ;
    }
    
}
