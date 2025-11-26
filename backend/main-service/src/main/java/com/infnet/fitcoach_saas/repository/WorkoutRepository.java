package com.infnet.fitcoach_saas.repository;

import com.infnet.fitcoach_saas.models.Workout;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface WorkoutRepository extends JpaRepository<Workout, Long> {
    List<Workout> findByTraineeId(Long traineeId);
}
