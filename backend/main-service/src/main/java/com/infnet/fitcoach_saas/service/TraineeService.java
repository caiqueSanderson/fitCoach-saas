package com.infnet.fitcoach_saas.service;

import com.infnet.fitcoach_saas.models.Trainee;
import com.infnet.fitcoach_saas.models.Workout;
import com.infnet.fitcoach_saas.repository.TraineeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TraineeService {
    private final TraineeRepository repository;

    public TraineeService(TraineeRepository repository){
        this.repository = repository;
    }

    public Trainee save(Trainee trainee){
        return repository.save(trainee);
    }

    public List<Trainee> findAll(){
        return repository.findAll();
    }

    public Optional<Trainee> findById(Long id){
        return repository.findById(id);
    }
}
