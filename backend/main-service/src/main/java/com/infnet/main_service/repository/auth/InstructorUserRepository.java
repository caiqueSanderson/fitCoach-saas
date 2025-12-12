package com.infnet.main_service.repository.auth;

import com.infnet.main_service.models.auth.InstructorUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface InstructorUserRepository extends JpaRepository<InstructorUser,Long> {
    Optional<InstructorUser> findByEmail(String email);
}
