package com.microservice.question.model;

import org.springframework.stereotype.Component;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Component
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "question")
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="ctry_seq")
    @SequenceGenerator(name = "ctry_seq", sequenceName = "ctry_seq", initialValue = 1, allocationSize=1)
    private Long id;

    @Column(name = "catagory", nullable = false)
    private String catagory;

    @Column(name = "diffcuilty", nullable = false)
    private String diffcuilty;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "option1", nullable = false)
    private String option1;

    @Column(name = "option2", nullable = false)
    private String option2;

    @Column(name = "option3", nullable = false)
    private String option3;

    @Column(name = "option4", nullable = false)
    private String option4;

    @Column(name = "answer", nullable = false)
    private String answer;


}
