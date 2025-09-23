package com.infnet.fitcoach_saas.models;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Workout {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String muscleGroup;
    private String description;
    private String videoUrl;

    @ManyToOne
    @JoinColumn(name = "trainee_id")
    private Trainee trainee;

    @ManyToOne
    @JoinColumn(name = "instructor_id")
    private Instructor instructor;
}
