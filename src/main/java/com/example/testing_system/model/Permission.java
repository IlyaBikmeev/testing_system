package com.example.testing_system.model;

public enum Permission {
    QUESTIONS_READ("questions:read"),
    QUESTIONS_WRITE("questions:write"),
    ANSWERS_READ("answers:read"),
    ANSWERS_WRITE("answers:write"),
    SUBJECTS_READ("subjects:read"),
    SUBJECTS_WRITE("subjects:write");


    private final String permission;

    Permission(String permission) {
        this.permission = permission;
    }

    public String getPermission() {
        return permission;
    }
}
