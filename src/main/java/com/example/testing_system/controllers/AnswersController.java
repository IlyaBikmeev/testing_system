package com.example.testing_system.controllers;

import com.example.testing_system.model.Answer;
import com.example.testing_system.services.AnswersService;
import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/answers")
public class AnswersController {
    private final AnswersService answersService;

    @GetMapping
    @PreAuthorize("hasAuthority('answers:read')")
    public List<Answer> getAll(@RequestParam(required = false) boolean correct) {
        return !correct ? answersService.findAll() : answersService.findAllCorrect();
    }

    @GetMapping("{id}")
    @PreAuthorize("hasAuthority('answers:read')")
    public Answer get(@PathVariable int id) {
        return answersService.findById(id);
    }

    @GetMapping("/prefix")
    @PreAuthorize("hasAuthority('answers:read')")
    public List<Answer> getByPrefix(@RequestParam String value) {
        return answersService.findByPrefix(value);
    }

    @PostMapping
    @PreAuthorize("hasAuthority('answers:write')")
    public Answer create(@RequestBody Answer answer) {
        return answersService.save(answer);
    }

    @DeleteMapping("{id}")
    @PreAuthorize("hasAuthority('answers:write')")
    public void delete(@PathVariable int id) {
        answersService.delete(id);
    }

    @PutMapping("{id}")
    @PreAuthorize("hasAuthority('answers:write')")
    public Answer update(@PathVariable int id,
                         @RequestBody Answer answer) {
        return answersService.update(id, answer);
    }

    @PatchMapping("{id}")
    @PreAuthorize("hasAuthority('answers:write')")
    public Answer partialUpdate(@PathVariable int id,
                                @RequestBody Answer answer) {
        return answersService.partialUpdate(id, answer);
    }
}
