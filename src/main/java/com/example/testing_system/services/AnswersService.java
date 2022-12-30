package com.example.testing_system.services;

import com.example.testing_system.model.Answer;
import com.example.testing_system.repositories.AnswersRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class AnswersService {
    private final AnswersRepository answersRepository;

    public List<Answer> findAll() {
        return answersRepository.findAll();
    }

    public Answer findById(int id) {
        return answersRepository.findById(id).orElseThrow();
    }

    public List<Answer> findAllCorrect() {
        return answersRepository.findByCorrectTrue();
    }

    public List<Answer> findByPrefix(String prefix) {
        return answersRepository.findByNameStartingWithIgnoreCase(prefix);
    }
}
