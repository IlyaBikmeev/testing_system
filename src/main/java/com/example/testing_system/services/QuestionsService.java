package com.example.testing_system.services;

import com.example.testing_system.model.Question;
import com.example.testing_system.repositories.QuestionsRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class QuestionsService {
    private final QuestionsRepository questionsRepository;

    public List<Question> findAll() {
        return questionsRepository.findAll();
    }

    public Question findById(int id) {
        return questionsRepository.findById(id).orElseThrow();
    }
}
