package com.microservice.quiz.feign;

import java.util.List;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import com.microservice.quiz.dto.QuestionResponse;
import com.microservice.quiz.dto.QuestionWrapper;

@FeignClient("QUESTION-MICROSERVICE")
public interface QuizInterface {
    @GetMapping("api/question/generate")
    public ResponseEntity<List<Long>> getRandomQuestions(@RequestParam("catagory") String catagory, @RequestParam("num") Integer numberOfQuestion); 

    @PostMapping("api/question/check")
    public ResponseEntity<Boolean> checkAnswer(@RequestBody QuestionResponse questionResponse); 
    
    @PostMapping("api/question/calculate-score")
    public ResponseEntity<Integer> calculateScore(@RequestBody List<QuestionResponse> questions); 

    @PostMapping("api/question/fetch-quiz")
    public ResponseEntity<List<QuestionWrapper>> getQuestionWrapper(@RequestBody List<Long> ids); 
}