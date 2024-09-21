package com.microservice.quiz.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.microservice.quiz.service.QuizService;
import com.microservice.quiz.dto.QuestionResponse;
import com.microservice.quiz.dto.QuizDemo;
import com.microservice.quiz.model.Quiz;
import java.util.List;
import java.util.NoSuchElementException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping("api/quiz")
public class QuizController {
    @Autowired
    private QuizService quizService;

    @GetMapping("all")
    public ResponseEntity<List<Quiz>> getAllQuiz(){
        return new ResponseEntity<>(quizService.getQuizes(),HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<QuizDemo> getQuiz(@PathVariable Long id) {
        try{
            return new ResponseEntity<>(quizService.getQuiz(id),HttpStatus.OK);
        }
        catch(NoSuchElementException e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
    
    @PostMapping
    public ResponseEntity<Quiz> addQuiz(@RequestParam String title, @RequestParam String catagory,@RequestParam Integer num) {
        return new ResponseEntity<>(quizService.addQuiz(title,catagory,num),HttpStatus.CREATED);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> deleteQuiz(@PathVariable Long id) {
        quizService.deleteQuiz(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("check-answer")
    public ResponseEntity<Boolean> checkAnswer(@RequestBody QuestionResponse questionResponse) {
        return new ResponseEntity<>(quizService.checkAnswer(questionResponse),HttpStatus.OK);
    }

    @PostMapping("calculate-score")
    public ResponseEntity<Integer> calculate(@RequestBody List<QuestionResponse> questionResponses) {
        return new ResponseEntity<>(quizService.calculate(questionResponses),HttpStatus.OK);
    }
    
}
