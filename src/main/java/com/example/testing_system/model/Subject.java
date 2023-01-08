package com.example.testing_system.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
@Table(name = "subject")
public class Subject {
    @Id
    @Column(name = "subject_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name_subject")
    private String name;

    @OneToMany(mappedBy = "subject")
    @JsonIgnore     //Чтобы не было зацикливания при сериализации в JSON.
    @ToString.Exclude
    private List<Question> questions;

}
