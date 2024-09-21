package com.microservice.quiz.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.microservice.quiz.model.Quiz;

public interface QuizRepository extends JpaRepository<Quiz, Long>{

}
