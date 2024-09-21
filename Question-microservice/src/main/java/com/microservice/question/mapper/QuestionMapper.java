package com.microservice.question.mapper;

import com.microservice.question.dto.QuestionWrapper;
import com.microservice.question.model.Question;

public class QuestionMapper {
    public static QuestionWrapper mapToQuestionWrapper(Question question){
        return new QuestionWrapper(question.getId(),
                                    question.getCatagory(), 
                                    question.getDiffcuilty(), 
                                    question.getOption1(), 
                                    question.getOption2(), 
                                    question.getOption3(), 
                                    question.getOption4()
                                );
    }
}
