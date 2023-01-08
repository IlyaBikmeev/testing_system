package com.example.testing_system.controllers;

import com.example.testing_system.model.Answer;
import com.example.testing_system.services.AnswersService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/answers")
public class AnswersController {
    private final AnswersService answersService;

    @GetMapping
    public List<Answer> getAll(@RequestParam(required = false) boolean correct) {
        return !correct ? answersService.findAll() : answersService.findAllCorrect();
    }

    @GetMapping("{id}")
    public Answer get(@PathVariable int id) {
        return answersService.findById(id);
    }

    @GetMapping("/prefix")
    public List<Answer> getByPrefix(@RequestParam String value) {
        return answersService.findByPrefix(value);
    }

    @PostMapping
    public Answer create(@RequestBody Answer answer) {
        return answersService.save(answer);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable int id) {
        answersService.delete(id);
    }

    @PutMapping("{id}")
    public Answer update(@PathVariable int id,
                         @RequestBody Answer answer) {
        return answersService.update(id, answer);
    }

    @PatchMapping("{id}")
    public Answer partialUpdate(@PathVariable int id,
                                @RequestBody Answer answer) {
        return answersService.partialUpdate(id, answer);
    }
}
