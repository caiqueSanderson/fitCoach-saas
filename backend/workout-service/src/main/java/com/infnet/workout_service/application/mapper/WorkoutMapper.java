package com.infnet.workout_service.application.mapper;

import com.infnet.workout_service.application.dto.WorkoutDTO;
import com.infnet.workout_service.domain.model.Workout;
import com.infnet.workout_service.domain.model.WorkoutExercise;

import java.util.List;
import java.util.stream.Collectors;

public class WorkoutMapper {
    public static Workout toDomain(WorkoutDTO dto) {
        if (dto == null) return null;
        List<WorkoutExercise> exercises = null;
        if (dto.getExercises() != null) {
            exercises = dto.getExercises().stream()
                    .map(e -> new WorkoutExercise(e.getExerciseId(), e.getSets(), e.getReps(), e.getRestSeconds()))
                    .collect(Collectors.toList());
        }
        return new Workout(dto.getName(), dto.getGoal(), exercises, dto.getNotes());
    }

    public static WorkoutDTO toDTO(Workout domain) {
        if (domain == null) return null;
        WorkoutDTO dto = new WorkoutDTO();
        dto.setId(domain.getId());
        dto.setName(domain.getName());
        dto.setGoal(domain.getGoal());
        dto.setNotes(domain.getNotes());
        if (domain.getExercises() != null) {
            List<WorkoutDTO.WorkoutExerciseDTO> ex = domain.getExercises().stream().map(e -> {
                WorkoutDTO.WorkoutExerciseDTO we = new WorkoutDTO.WorkoutExerciseDTO();
                we.setExerciseId(e.getExerciseId());
                we.setSets(e.getSets());
                we.setReps(e.getReps());
                we.setRestSeconds(e.getRestSeconds());
                return we;
            }).collect(Collectors.toList());
            dto.setExercises(ex);
        }
        return dto;
    }
}
