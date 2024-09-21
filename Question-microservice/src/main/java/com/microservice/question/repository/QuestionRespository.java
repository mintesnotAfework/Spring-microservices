package com.microservice.question.repository;

import com.microservice.question.model.Question;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


@Repository
public interface QuestionRespository extends JpaRepository<Question,Long> {
    List<Question> findAllByCatagory(String catagory);

    @Query(value = "SELECT q.id FROM question q WHERE q.catagory=:catagory ORDER BY RANDOM() LIMIT :numberOfQuestion",nativeQuery = true)
    List<Long> findAllRandomByCatagory(String catagory, Integer numberOfQuestion);
}
