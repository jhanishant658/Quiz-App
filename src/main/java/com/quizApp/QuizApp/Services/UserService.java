package com.quizApp.QuizApp.Services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.quizApp.QuizApp.Models.User;
import com.quizApp.QuizApp.Repositories.UserRepository;
import com.quizApp.QuizApp.Request.LoginReq;

@Service
public class UserService {
    @Autowired
    private  UserRepository userRepository ;
    public String registerUser(User user){
        //this method for register user and save it in database 
        if(userRepository.existsById(user.getEmail())){
            return "User already exists" ;
        }
       String password = user.getPassword() ; 
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder() ;
        String encodedPassword = encoder.encode(password) ;
        user.setPassword(encodedPassword);
        userRepository.save(user);
        return "User registered successfully" ;
    }
    public String LoginUser(LoginReq req){
        User user = userRepository.findByEmail(req.getEmail()) ;
        if(user == null){
            return "User not found" ;
        }
            BCryptPasswordEncoder encoder = new BCryptPasswordEncoder() ;
            if(!encoder.matches(req.getPassword(), ((User)user).getPassword())){
                return "Password is incorrect" ;
            }
        return "User logged in successfully" ;
    }

}
