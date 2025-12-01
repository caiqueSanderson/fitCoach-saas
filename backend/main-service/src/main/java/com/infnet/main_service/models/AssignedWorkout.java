package com.infnet.main_service.models;

import jakarta.persistence.*;
import lombok.Data;


@Data
@Entity
@Table(name = "assigned_workouts")
public class AssignedWorkout {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String workoutId;

    @ManyToOne
    @JoinColumn(name = "trainee_id")
    private com.infnet.main_service.models.Trainee trainee;
}
