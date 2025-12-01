package com.infnet.main_service.models;

import com.infnet.main_service.models.enums.BiologicalSex;
import com.infnet.main_service.models.enums.MedicalHistoryStatus;
import jakarta.persistence.*;
import lombok.Data;

import java.time.Instant;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Entity
@Data
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
    private LocalDate startMenstrualPeriod;
    private LocalDate endMenstrualPeriod;

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

    private Instant createdOn;
    private Instant updatedOn;

    @PrePersist
    public void prePersist() {
        this.createdOn = Instant.now();
    }

    @PreUpdate
    public void preUpdate() {
        this.updatedOn = Instant.now();
    }

    @Enumerated(EnumType.STRING)
    private MedicalHistoryStatus status; // DRAFT, SUBMITTED, REVIEWED, APPROVED

    @Version
    private Long version;

    @OneToMany(mappedBy = "medicalHistory", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<com.infnet.main_service.models.MedicalHistoryPhoto> photos;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "trainee_id")
    private com.infnet.main_service.models.Trainee trainee;
}