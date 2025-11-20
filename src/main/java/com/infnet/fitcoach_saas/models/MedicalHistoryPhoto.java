package com.infnet.fitcoach_saas.models;

import jakarta.persistence.*;
import lombok.Data;
import org.antlr.v4.runtime.misc.NotNull;

@Data
@Entity
@Table(name = "medical_history_photo",
        uniqueConstraints = @UniqueConstraint(columnNames = {"medical_history_id", "position"}))
public class MedicalHistoryPhoto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Enumerated(EnumType.STRING)
    private PhotoPosition position;

    @NotNull
    private String fileUri;

    private Long sizeBytes;
    private String mimeType;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "medical_history_id", nullable = false)
    private MedicalHistory medicalHistory;
}
