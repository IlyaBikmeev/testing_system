package com.example.testing_system.repositories;

import com.example.testing_system.model.Answer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AnswersRepository extends JpaRepository<Answer, Integer> {
    List<Answer> findByCorrectTrue();

    List<Answer> findByNameStartingWithIgnoreCase(String prefix);
}
