package com.infnet.fitcoach_saas.models;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "trainees")
public class Trainee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String cpf;

    @ManyToOne
    @JoinColumn(name = "instructor_id")
    private Instructor instructor;

}
