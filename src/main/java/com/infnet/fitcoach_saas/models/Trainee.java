package com.infnet.fitcoach_saas.models;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Trainee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private Integer age;
    private Double weight;
    private Double height;

    @ManyToOne
    @JoinColumn(name = "instructor_id")
    private Instructor instructor;

}
