package com.example.testing_system.controllers;

import com.example.testing_system.model.Subject;
import com.example.testing_system.services.SubjectsService;
import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/subjects")
public class SubjectsController {
    private final SubjectsService subjectsService;

    //Получить все предметы в формате JSON
    @GetMapping
    @PreAuthorize("hasAuthority('subjects:read')")
    public List<Subject> getAll(@RequestParam(required = false) String name) {
        return name == null ? subjectsService.findAll() :
                Collections.singletonList(subjectsService.findByName(name));
    }

    //Получить предмет с конкретным id в формате JSON
    @GetMapping("{id}")
    @PreAuthorize("hasAuthority('subjects:read')")
    public Subject get(@PathVariable int id) {
        return subjectsService.findById(id);
    }

    @PostMapping
    @PreAuthorize("hasAuthority('subjects:write')")
    public Subject createSubject(@RequestBody Subject subject) {
        return subjectsService.save(subject);
    }
}
