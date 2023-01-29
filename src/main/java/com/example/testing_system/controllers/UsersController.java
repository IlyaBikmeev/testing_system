package com.example.testing_system.controllers;

import com.example.testing_system.model.Attempt;
import com.example.testing_system.model.User;
import com.example.testing_system.services.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/*
GET '/user/{user_id}/attempts'
GET '/user/{user_id}/attempts/{attempt_id}'
 */
@RestController
@RequestMapping("/user")
public class UsersController {

    private final UsersService usersService;

    @Autowired
    public UsersController(UsersService usersService) {
        this.usersService = usersService;
    }

    @GetMapping("/{id}")
    public User userInfo(@PathVariable int id) {
        return usersService.getById(id);
    }

    @GetMapping("/{userId}/attempts")
    @PreAuthorize("@userDetailsServiceImpl.hasUserId(authentication, #userId) or hasAuthority('attempts:read')")
    public List<Attempt> userAttempts(@PathVariable int userId) {
        return usersService.getById(userId)
                .getStudent().getAttempts();
    }
}
