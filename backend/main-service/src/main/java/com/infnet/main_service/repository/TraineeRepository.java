package com.infnet.main_service.repository;

import com.infnet.main_service.models.Trainee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TraineeRepository extends JpaRepository<Trainee, Long> {
}
