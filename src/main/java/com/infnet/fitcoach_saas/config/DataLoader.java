package com.infnet.fitcoach_saas.config;

import com.infnet.fitcoach_saas.models.Role;
import com.infnet.fitcoach_saas.models.User;
import com.infnet.fitcoach_saas.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public DataLoader(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void run(String... args) {
        if (userRepository.count() == 0) {
            User instructor = User.builder()
                    .username("instructor")
                    .password(passwordEncoder.encode("123456"))
                    .role(Role.ROLE_INSTRUCTOR)
                    .build();

            User trainee = User.builder()
                    .username("trainee")
                    .password(passwordEncoder.encode("123456"))
                    .role(Role.ROLE_TRAINEE)
                    .build();

            userRepository.save(instructor);
            userRepository.save(trainee);
        }
    }
}
