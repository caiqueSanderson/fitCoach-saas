package com.infnet.fitcoach_saas.service;

import com.infnet.fitcoach_saas.models.MedicalHistory;
import com.infnet.fitcoach_saas.repository.MedicalHistoryRepository;
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
        return repository.findAll()
                .stream()
                .filter(a -> a.getTrainee().getId().equals(traineeId))
                .findFirst();
    }
}
