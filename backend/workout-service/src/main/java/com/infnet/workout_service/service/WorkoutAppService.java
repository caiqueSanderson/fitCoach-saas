package com.infnet.workout_service.service;

import com.infnet.workout_service.application.dto.WorkoutDTO;
import com.infnet.workout_service.application.mapper.WorkoutMapper;
import com.infnet.workout_service.domain.model.Workout;
import com.infnet.workout_service.infra.messaging.WorkoutEventProducer;
import com.infnet.workout_service.infra.repository.WorkoutRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class WorkoutAppService {
    private final WorkoutRepository workoutRepository;
    private final WorkoutEventProducer eventProducer;

    public WorkoutAppService(WorkoutRepository workoutRepository, WorkoutEventProducer eventProducer) {
        this.workoutRepository = workoutRepository;
        this.eventProducer = eventProducer;
    }

    public WorkoutDTO createWorkout(WorkoutDTO dto) {
        Workout domain = WorkoutMapper.toDomain(dto);
        Workout saved = workoutRepository.save(domain);

        eventProducer.publishWorkoutCreated(saved.getId(), saved.getName());
        return WorkoutMapper.toDTO(saved);
    }

    public List<WorkoutDTO> listAll() {
        return workoutRepository.findAll().stream().map(WorkoutMapper::toDTO).collect(Collectors.toList());
    }

    public WorkoutDTO findById(String id) {
        return workoutRepository.findById(id).map(WorkoutMapper::toDTO).orElse(null);
    }

    public WorkoutDTO update(String id, WorkoutDTO dto) {
        return workoutRepository.findById(id).map(existing -> {
            existing.setName(dto.getName());
            existing.setGoal(dto.getGoal());
            existing.setExercises(WorkoutMapper.toDomain(dto).getExercises());
            existing.setNotes(dto.getNotes());
            Workout updated = workoutRepository.save(existing);
            return WorkoutMapper.toDTO(updated);
        }).orElse(null);
    }

    public void delete(String id) {
        workoutRepository.deleteById(id);
    }
}
