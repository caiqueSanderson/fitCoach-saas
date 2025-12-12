package com.infnet.main_service.controller.auth;

import com.infnet.main_service.dto.LoginDTO;
import com.infnet.main_service.dto.TokenResponse;
import com.infnet.main_service.models.auth.TraineeUser;
import com.infnet.main_service.repository.TraineeRepository;
import com.infnet.main_service.repository.auth.TraineeUserRepository;
import com.infnet.main_service.service.auth.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {
    private final AuthenticationManager authManager;
    private final JwtService jwtService;
    private final TraineeUserRepository traineeRepository;

    @PostMapping("/login")
    public ResponseEntity<TokenResponse> login(@RequestBody LoginDTO dto) {

        Authentication auth = authManager.authenticate(
                new UsernamePasswordAuthenticationToken(dto.getLogin(), dto.getPassword())
        );

        String token = jwtService.generateToken(auth);
        return ResponseEntity.ok(new TokenResponse(token));
    }

    @PostMapping("/trainee/login")
    public ResponseEntity<?> traineeLogin(@RequestBody(required = true) TraineeLoginRequest body) {
        TraineeUser traineeUser = traineeRepository.findByCpf(body.getCpf())
                .orElse(null);

        if (traineeUser == null) {
            return ResponseEntity.status(404).body("Trainee not found");
        }

        UsernamePasswordAuthenticationToken authToken =
                new UsernamePasswordAuthenticationToken(traineeUser, null, traineeUser.getAuthorities());

        String token = jwtService.generateToken(authToken); // note: generateToken accepts Authentication

        return ResponseEntity.ok(new TokenResponse(token));
    }

    public static class TraineeLoginRequest {
        private String cpf;
        public String getCpf() { return cpf; }
        public void setCpf(String cpf) { this.cpf = cpf; }
    }
}
