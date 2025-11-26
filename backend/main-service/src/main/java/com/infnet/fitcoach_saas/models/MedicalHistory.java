package com.infnet.fitcoach_saas.models;

import jakarta.persistence.*;
import lombok.Data;

import java.time.Instant;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name = "medical_history")
public class MedicalHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate birthday;
    @Enumerated(EnumType.STRING)
    private BiologicalSex biologicalSex; // MALE / FEMALE
    private Boolean hasChildren;
    private Boolean normalMenstrualCycle;
    private Date startMenstrualPeriod;
    private Date endMenstrualPeriod;

    private String goal;
    private Double weight;
    private Double height;

    private String dailyRoutine;
    private String healthIssues;
    private Boolean usesContinuousMedication;
    private Integer drinksAlcohol;
    private Integer sleepHours;
    private String discomfortsOrInjuries;

    private String workoutFrequency;
    private String medications;
    private Boolean smoker;

    private Boolean nutritionistFollowUp;
    private Boolean cardiologistFollowUp;
    private Boolean physiotherapistFollowUp;
    private Boolean orthopedistFollowUp;
    private String otherFollowUp;

    private Instant createdOn = Instant.now();
    private Instant updatedOn;

    @Enumerated(EnumType.STRING)
    private MedicalHistoryStatus status; // DRAFT, SUBMITTED, REVIEWED, APPROVED

    @Version
    private Long version;

    @OneToMany(mappedBy = "medicalHistory", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<MedicalHistoryPhoto> photos;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "aluno_id")
    private Trainee trainee;
}