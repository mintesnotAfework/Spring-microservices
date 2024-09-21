package com.microservice.question.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.microservice.question.dto.QuestionResponse;
import com.microservice.question.dto.QuestionWrapper;
import com.microservice.question.model.Question;
import com.microservice.question.service.QuestionService;
import java.util.List;
import java.util.NoSuchElementException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("api/question")
public class QuestionController {
    @Autowired
    private QuestionService questionService;
    
    @GetMapping("all")
    public ResponseEntity<List<Question>> getAllQuestions() {
        return new ResponseEntity<>(questionService.getAllQuestions(), HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<Question> getQuestion(@PathVariable("id") Long id) {
        try{
            return new ResponseEntity<>(questionService.getQuestion(id), HttpStatus.OK);
        }
        catch(NoSuchElementException e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("search")
    public ResponseEntity<List<Question>> getAllQuestionsByCatagory(@RequestParam("catagory") String catagory) {
        return new ResponseEntity<>(questionService.getAllQuestionsByCatagory(catagory), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Question> addQuestion(@RequestBody Question question) {
        return new ResponseEntity<>(questionService.addQuestion(question), HttpStatus.CREATED); 
    }

    @PostMapping("all")
    public ResponseEntity<List<Question>> addQuestions(@RequestBody List<Question> questions) {
        return new ResponseEntity<>(questionService.addQuestions(questions), HttpStatus.CREATED); 
    }
    
    @PutMapping
    public ResponseEntity<Question> updateQuestion(@RequestBody Question question) {
        return new ResponseEntity<>(questionService.updateQuestion(question), HttpStatus.CREATED); 
    }
    
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteQuestion(@PathVariable Long id){
        questionService.deleteQuestion(id);
        return new ResponseEntity<>("deleted", HttpStatus.OK); 
    }

    @GetMapping("generate")
    public ResponseEntity<List<Long>> getRandomQuestions(@RequestParam("catagory") String catagory, @RequestParam("num") Integer numberOfQuestion) {
        try{
            return new ResponseEntity<>(questionService.getRandomQuestions(catagory,numberOfQuestion), HttpStatus.OK); 
        }
        catch(NoSuchElementException e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("check")
    public ResponseEntity<Boolean> checkAnswer(@RequestBody QuestionResponse questionResponse) {
        try{
            return new ResponseEntity<>(questionService.checkAnswer(questionResponse),HttpStatus.OK);
        }
        catch(NoSuchElementException e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
    

    @PostMapping("calculate-score")
    public ResponseEntity<Integer> calculateScore(@RequestBody List<QuestionResponse> questions) {
        try{
            return new ResponseEntity<>(questionService.calculateScore(questions), HttpStatus.OK); 
        }
        catch(NoSuchElementException e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("fetch-quiz")
    public ResponseEntity<List<QuestionWrapper>> getQuestionWrapper(@RequestBody List<Long> ids) {
        try{
            return new ResponseEntity<>(questionService.getQuestionWrappers(ids), HttpStatus.OK); 
        }
        catch(NoSuchElementException e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
    
    
}
