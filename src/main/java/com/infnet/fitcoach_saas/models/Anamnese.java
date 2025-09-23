package com.infnet.fitcoach_saas.models;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Anamnese {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String healthIssues;
    private String goal;
    private String workoutFrequency;
    private String medications;
    private Boolean smoker;
    private Boolean alcoholConsumption;

    @ManyToOne
    @JoinColumn(name = "aluno_id")
    private Trainee trainee;
}