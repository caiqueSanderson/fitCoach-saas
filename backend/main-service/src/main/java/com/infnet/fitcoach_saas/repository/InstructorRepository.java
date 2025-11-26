package com.infnet.fitcoach_saas.repository;

import com.infnet.fitcoach_saas.models.Instructor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InstructorRepository extends JpaRepository<Instructor, Long> {
}
