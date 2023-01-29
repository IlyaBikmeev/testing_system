package com.example.testing_system.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "attempt")
@Data
public class Attempt {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "attempt_id")
    private int id;

    @Column(name = "date_attempt")
    private Date dateAttempt;

    @Column(name = "result")
    private int result;

    @ManyToOne
    @JoinColumn(name = "student_id", referencedColumnName = "person_id")
    private Person person;
}
