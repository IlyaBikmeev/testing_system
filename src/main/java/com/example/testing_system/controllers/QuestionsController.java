package com.example.testing_system.controllers;

import com.example.testing_system.model.Question;
import com.example.testing_system.services.QuestionsService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/questions")
public class QuestionsController {
    private final QuestionsService questionsService;

    @GetMapping
    public List<Question> getAll() {
        return questionsService.findAll();
    }

    @GetMapping("{id}")
    public Question get(@PathVariable int id) {
        return questionsService.findById(id);
    }

    @PostMapping
    public Question create(@RequestBody Question question) {
        return questionsService.save(question);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable int id) {
        questionsService.delete(id);
    }
}
