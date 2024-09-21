package com.microservice.quiz.dto;

import org.springframework.stereotype.Component;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Component
public class QuestionWrapper {
    private Long id;
    private String catagory;
    private String diffcuilty;
    private String option1;
    private String option2;
    private String option3;
    private String option4;
}
