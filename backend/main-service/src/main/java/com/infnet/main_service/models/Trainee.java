package com.infnet.main_service.models;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "trainee")
public class Trainee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    @Column(nullable = false, unique = true, length = 11)
    private String cpf;

    @ManyToOne
    @JoinColumn(name = "instructor_id")
    private com.infnet.main_service.models.Instructor instructor;

    @OneToOne(mappedBy = "trainee", cascade = CascadeType.ALL)
    private com.infnet.main_service.models.MedicalHistory medicalHistory;

}
