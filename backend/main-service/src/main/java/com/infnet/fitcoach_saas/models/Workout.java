package com.infnet.fitcoach_saas.models;

import jakarta.persistence.*;

@Entity
public class Workout {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String muscleGroup;
    private String description;
    private String videoUrl;
}
