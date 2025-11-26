package com.infnet.fitcoach_saas.service;

import com.infnet.fitcoach_saas.models.Workout;
import com.infnet.fitcoach_saas.repository.WorkoutRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class WorkoutService {
    private final WorkoutRepository repository;

    public WorkoutService(WorkoutRepository repository){
        this.repository = repository;
    }

    public Workout save(Workout workout){
        return repository.save(workout);
    }

    public List<Workout> findAll(){
        return repository.findAll();
    }

    public Optional<Workout> findById(Long id){
        return repository.findById(id);
    }

    public List<Workout> findByTrainee(Long traineeId) {
        return repository.findByTraineeId(traineeId);
    }
}
