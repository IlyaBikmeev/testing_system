package com.example.testing_system.services;

import com.example.testing_system.model.User;
import com.example.testing_system.repositories.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsersService {
    private final UsersRepository usersRepository;

    @Autowired
    public UsersService(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    public User getById(int id) {
        return usersRepository.findById(id).orElseThrow();
    }
}
