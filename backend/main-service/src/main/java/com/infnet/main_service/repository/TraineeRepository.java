package com.infnet.main_service.repository;

import com.infnet.main_service.models.Trainee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TraineeRepository extends JpaRepository<Trainee, Long> {
    Optional<Trainee> findByCpf(String cpf);
}
