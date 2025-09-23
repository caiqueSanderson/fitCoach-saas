package com.infnet.fitcoach_saas.service;

import com.infnet.fitcoach_saas.models.Anamnese;
import com.infnet.fitcoach_saas.repository.AnamneseRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AnamneseService {
    private final AnamneseRepository repository;

    public AnamneseService(AnamneseRepository repository) {
        this.repository = repository;
    }

    public Anamnese save(Anamnese anamnese) {
        return repository.save(anamnese);
    }

    public Optional<Anamnese> findByTraineeId(Long traineeId) {
        return repository.findAll()
                .stream()
                .filter(a -> a.getTrainee().getId().equals(traineeId))
                .findFirst();
    }
}
