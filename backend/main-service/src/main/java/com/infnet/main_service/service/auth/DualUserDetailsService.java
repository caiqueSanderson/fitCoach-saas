package com.infnet.main_service.service.auth;

import com.infnet.main_service.repository.auth.InstructorUserRepository;
import com.infnet.main_service.repository.auth.TraineeUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DualUserDetailsService implements UserDetailsService {
    private final InstructorUserRepository instructorUserRepo;
    private final TraineeUserRepository traineeUserRepo;

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {

        if (login.matches("\\d{11}")) {
            return traineeUserRepo.findByCpf(login)
                    .orElseThrow(() -> new UsernameNotFoundException("Trainee not found"));
        }

        if (login.contains("@")) {
            return instructorUserRepo.findByEmail(login)
                    .orElseThrow(() -> new UsernameNotFoundException("Instructor not found"));
        }

        throw new UsernameNotFoundException("Invalid login format");
    }
}
