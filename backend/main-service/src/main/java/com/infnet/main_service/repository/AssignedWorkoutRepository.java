package com.infnet.main_service.repository;

import com.infnet.main_service.models.AssignedWorkout;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AssignedWorkoutRepository extends JpaRepository<AssignedWorkout, Long> {
    Optional<AssignedWorkout> findByTraineeId(Long traineeId);
}
