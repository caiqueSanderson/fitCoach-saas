package com.infnet.main_service.service;

import com.infnet.main_service.clients.WorkoutClientService;
import com.infnet.main_service.clients.dto.WorkoutDTO;
import com.infnet.main_service.models.AssignedWorkout;
import com.infnet.main_service.models.Trainee;
import com.infnet.main_service.repository.AssignedWorkoutRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AssignedWorkoutService {
    private final AssignedWorkoutRepository repository;
    private final WorkoutClientService workoutClientService;

    public AssignedWorkoutService(AssignedWorkoutRepository repo, WorkoutClientService workoutClientService) {
        this.repository = repo;
        this.workoutClientService = workoutClientService;
    }

    public AssignedWorkout assignWorkout(Long traineeId, String workoutId) {
        AssignedWorkout aw = new AssignedWorkout();
        Trainee t = new Trainee();
        t.setId(traineeId);

        aw.setTrainee(t);
        aw.setWorkoutId(workoutId);

        return repository.save(aw);
    }

    public Optional<WorkoutDTO> getWorkoutForTrainee(Long traineeId) {
        return repository.findByTraineeId(traineeId)
                .flatMap(aw -> workoutClientService.getWorkoutById(aw.getWorkoutId()));
    }
}
