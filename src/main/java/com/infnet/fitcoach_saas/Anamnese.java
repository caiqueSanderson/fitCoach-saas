package com.infnet.fitcoach_saas;

import jakarta.persistence.*;

@Entity
public class Anamnese {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String objetivo;
    private String frequenciaExercicio;

    @ManyToOne
    @JoinColumn(name = "aluno_id")
    private Trainee trainee;

    // Getters e Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getObjetivo() {
        return objetivo;
    }

    public void setObjetivo(String objetivo) {
        this.objetivo = objetivo;
    }

    public String getFrequenciaExercicio() {
        return frequenciaExercicio;
    }

    public void setFrequenciaExercicio(String frequenciaExercicio) {
        this.frequenciaExercicio = frequenciaExercicio;
    }

    public Trainee getTrainee() {
        return trainee;
    }

    public void setTrainee(Trainee trainee) {
        this.trainee = trainee;
    }
}