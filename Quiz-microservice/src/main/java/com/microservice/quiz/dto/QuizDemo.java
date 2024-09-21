package com.microservice.quiz.dto;

import org.springframework.stereotype.Component;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Component
public class QuizDemo {
    private Long id;
    private String title;
    private List<QuestionWrapper> questionWrapper;
}
