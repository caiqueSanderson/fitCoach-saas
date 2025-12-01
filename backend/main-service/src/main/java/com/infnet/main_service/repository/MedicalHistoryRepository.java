package com.infnet.main_service.repository;

import com.infnet.main_service.models.MedicalHistory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MedicalHistoryRepository extends JpaRepository<MedicalHistory, Long> {
    Optional<MedicalHistory> findByTraineeId(Long traineeId);
}
