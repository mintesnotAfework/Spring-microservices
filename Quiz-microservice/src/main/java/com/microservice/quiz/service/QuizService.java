package com.microservice.quiz.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.microservice.quiz.repository.QuizRepository;
import com.microservice.quiz.dto.QuestionResponse;
import com.microservice.quiz.dto.QuestionWrapper;
import com.microservice.quiz.dto.QuizDemo;
import com.microservice.quiz.feign.QuizInterface;
import com.microservice.quiz.model.Quiz;


@Service
public class QuizService {
    @Autowired
    private QuizRepository quizRepository;

    @Autowired
    private QuizInterface quizQuestionInterface;


    public List<Quiz> getQuizes(){
        return quizRepository.findAll();
    }

    public QuizDemo getQuiz(Long id){
        Quiz quiz = quizRepository.findById(id).orElseThrow();
        List<QuestionWrapper> questions = quizQuestionInterface.getQuestionWrapper(quiz.getQuestionsId()).getBody();
        QuizDemo quizDemo = new QuizDemo();
        quizDemo.setId(quiz.getId());
        quizDemo.setQuestionWrapper(questions);
        quizDemo.setTitle(quiz.getTitle());
        return quizDemo;
    }

    public Quiz addQuiz(String title,String catagory,Integer num){
        List<Long> questionsId = quizQuestionInterface.getRandomQuestions(catagory, num).getBody();
        Quiz quiz = new Quiz();
        quiz.setTitle(title);
        quiz.setQuestionsId(questionsId);
        return quizRepository.save(quiz);
    }

    public void deleteQuiz(Long id){
        quizRepository.deleteById(id);
    }

    public boolean checkAnswer(QuestionResponse questionResponse){
        return quizQuestionInterface.checkAnswer(questionResponse).getBody();
    }

    public Integer calculate(List<QuestionResponse> questionResponses) {
        return quizQuestionInterface.calculateScore(questionResponses).getBody();
    }


}
