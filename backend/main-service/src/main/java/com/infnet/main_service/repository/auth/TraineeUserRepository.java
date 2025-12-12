package com.infnet.main_service.repository.auth;

import com.infnet.main_service.models.auth.TraineeUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TraineeUserRepository extends JpaRepository<TraineeUser, Long> {
    Optional<TraineeUser> findByCpf(String cpf);
}
