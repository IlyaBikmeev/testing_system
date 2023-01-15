package com.example.testing_system.model;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Set;
import java.util.stream.Collectors;

public enum Role {
    STUDENT(Set.of(Permission.QUESTIONS_READ, Permission.SUBJECTS_READ)),
    TEACHER(Set.of(Permission.QUESTIONS_READ, Permission.QUESTIONS_WRITE,
            Permission.SUBJECTS_READ, Permission.SUBJECTS_WRITE,
            Permission.ANSWERS_READ, Permission.ANSWERS_WRITE));

    private final Set<Permission> permissions;

    Role(Set<Permission> permissions) {
        this.permissions = permissions;
    }

    public Set<Permission> getPermissions() {
        return permissions;
    }

    public Set<GrantedAuthority> getAuthorities() {
        return this.permissions.stream()
                .map(permission -> new SimpleGrantedAuthority(permission.getPermission()))
                .collect(Collectors.toSet());
    }
}
