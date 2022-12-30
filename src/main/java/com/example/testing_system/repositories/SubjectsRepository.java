package com.example.testing_system.repositories;

import com.example.testing_system.model.Subject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubjectsRepository extends JpaRepository<Subject, Integer> {
    Subject findByName(String name);
}
