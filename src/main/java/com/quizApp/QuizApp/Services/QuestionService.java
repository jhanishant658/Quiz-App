package com.quizApp.QuizApp.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.quizApp.QuizApp.Models.Question;
import com.quizApp.QuizApp.Repositories.QuestionRepository;

@Service
public class QuestionService {
    @Autowired 
    private QuestionRepository questionRepository ;
    public  ResponseEntity<List<Question>> getAllQuestions() {
        return new ResponseEntity<>(questionRepository.findAll(), HttpStatus.OK);
    }
    public ResponseEntity<List<Question>> getQuestionByCategory(String category){
        return new ResponseEntity<>(questionRepository.findByCategory(category), HttpStatus.OK);
    }
    public ResponseEntity<Question> addQuestion(Question question){
        return new ResponseEntity<>(questionRepository.save(question), HttpStatus.CREATED);
    }

}
