package com.infnet.main_service.service;

import com.infnet.main_service.models.MedicalHistory;
import com.infnet.main_service.repository.MedicalHistoryRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MedicalHistoryService {
    private final MedicalHistoryRepository repository;

    public MedicalHistoryService(MedicalHistoryRepository repository) {
        this.repository = repository;
    }

    public MedicalHistory save(MedicalHistory medicalHistory) {
        return repository.save(medicalHistory);
    }

    public Optional<MedicalHistory> findByTraineeId(Long traineeId) {
        return repository.findByTraineeId(traineeId);
    }
}
