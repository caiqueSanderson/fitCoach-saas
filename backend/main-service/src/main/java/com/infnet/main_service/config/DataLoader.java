package com.infnet.main_service.config;

import com.infnet.main_service.models.auth.InstructorUser;
import com.infnet.main_service.models.auth.TraineeUser;
import com.infnet.main_service.models.enums.Role;
import com.infnet.main_service.repository.auth.InstructorUserRepository;
import com.infnet.main_service.repository.auth.TraineeUserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {
    private final InstructorUserRepository instructorRepository;
    private final TraineeUserRepository traineeRepository;
    private final PasswordEncoder passwordEncoder;

    public DataLoader(InstructorUserRepository instructorRepository,
                      TraineeUserRepository traineeRepository,
                      PasswordEncoder passwordEncoder) {
        this.instructorRepository = instructorRepository;
        this.traineeRepository = traineeRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void run(String... args) {
        if (instructorRepository.count() == 0) {
            InstructorUser instructor = InstructorUser.builder()
                    .email("instructor@fitcoach.com")
                    .password(passwordEncoder.encode("123456"))
                    .role(Role.ROLE_INSTRUCTOR)
                    .build();
            instructorRepository.save(instructor);
        }

        if (traineeRepository.count() == 0) {
            TraineeUser trainee = TraineeUser.builder()
                    .cpf("12345678900")
                    .password(null)
                    .role(Role.ROLE_TRAINEE)
                    .build();
            traineeRepository.save(trainee);
        }
    }
}
