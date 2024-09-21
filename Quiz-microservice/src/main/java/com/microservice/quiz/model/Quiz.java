package com.microservice.quiz.model;

import java.util.List;
import org.springframework.stereotype.Component;
import jakarta.persistence.ElementCollection;
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
@Table(name = "quiz")
public class Quiz {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="ctry_seq")
    @SequenceGenerator(name = "ctry_seq", sequenceName = "ctry_seq", initialValue = 1, allocationSize=1)
    private Long id;

    private String title;

    @ElementCollection
    private List<Long> questionsId;

}
