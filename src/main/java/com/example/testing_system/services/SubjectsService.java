package com.example.testing_system.services;

import com.example.testing_system.model.Subject;
import com.example.testing_system.repositories.SubjectsRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class SubjectsService {
    private final SubjectsRepository subjectsRepository;

    public List<Subject> findAll() {
        return subjectsRepository.findAll();
    }

    public Subject findById(int id) {
        return subjectsRepository.findById(id).orElseThrow();
    }

    public Subject findByName(String name) {
        return subjectsRepository.findByName(name);
    }
}
