package com.infnet.main_service.models;

import jakarta.persistence.*;
import lombok.Data;

import java.time.Instant;

@Entity
@Data
@Table(name = "trainee_access_tokens")
public class TraineeAcessToken {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String token;
    private Long traineeId;
    private Instant expiresAt;
}
