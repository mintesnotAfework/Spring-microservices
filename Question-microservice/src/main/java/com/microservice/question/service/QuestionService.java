package com.microservice.question.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import com.microservice.question.dto.QuestionResponse;
import com.microservice.question.dto.QuestionWrapper;
import com.microservice.question.mapper.QuestionMapper;
import com.microservice.question.model.Question;
import com.microservice.question.repository.QuestionRespository;

@Service
public class QuestionService {
    @Autowired
    private QuestionRespository questionRespository;

    public List<Question> getAllQuestions(){
        return questionRespository.findAll();
    }

    public List<Question> getAllQuestionsByCatagory(String catagory) {
        return questionRespository.findAllByCatagory(catagory);
    }

    public Question addQuestion(Question question) {
        return questionRespository.save(question);
    }

    public Question updateQuestion(Question question) {
        return questionRespository.save(question);
    }

    public void deleteQuestion(Long id) {
        questionRespository.deleteById(id);
    }

    public List<Question> addQuestions(List<Question> questions) {
        List<Question> savedQuestions = new ArrayList<>();
        for(Question q : questions){
            savedQuestions.add(questionRespository.save(q));
        }
        return savedQuestions;
    }

    public Question getQuestion(Long id) {
        return questionRespository.findById(id).orElseThrow();
    }

    public List<Long> getRandomQuestions(String catagory, Integer numberOfQuestion) {
        return questionRespository.findAllRandomByCatagory(catagory, numberOfQuestion);
    }

    public Integer calculateScore(List<QuestionResponse> questions) {
        Integer right = 0;
        for(QuestionResponse q : questions){
            Question question = questionRespository.findById(q.getId()).orElseThrow();
            if(question.getAnswer().equals(q.getAnswer())){
                right++;
            }
        }
        return right;
    }

    public Boolean checkAnswer(QuestionResponse questionResponse) {
        Boolean answer = false;
        Question question = questionRespository.findById(questionResponse.getId()).orElseThrow();

        if(question.getAnswer().equals(questionResponse.getAnswer())){
            answer = true;
        }

        return answer;
    }

    public List<QuestionWrapper> getQuestionWrappers(List<Long> ids) {
        List<QuestionWrapper> questions = new ArrayList<>();
        for(Long id : ids){
            questions.add(QuestionMapper.mapToQuestionWrapper(questionRespository.findById(id).orElseThrow()));
        }
        
        return questions;
    }
}
