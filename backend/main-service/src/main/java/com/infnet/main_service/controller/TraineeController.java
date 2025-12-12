package com.infnet.main_service.controller;

import com.infnet.main_service.models.MedicalHistory;
import com.infnet.main_service.models.auth.TraineeUser;
import com.infnet.main_service.models.enums.MedicalHistoryStatus;
import com.infnet.main_service.service.AssignedWorkoutService;
import com.infnet.main_service.service.MedicalHistoryService;
import com.infnet.main_service.service.TraineeService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/trainee")
public class TraineeController {
    private final MedicalHistoryService historyService;
    private final AssignedWorkoutService workoutService;
    private final TraineeService traineeService;

    public TraineeController(
            MedicalHistoryService historyService,
            AssignedWorkoutService workoutService,
            TraineeService traineeService
    ) {
        this.historyService = historyService;
        this.workoutService = workoutService;
        this.traineeService = traineeService;
    }

    // ------------------------ MEDICAL HISTORY --------------------------

    @PostMapping("/history")
    @PreAuthorize("hasRole('TRAINEE')")
    public ResponseEntity<MedicalHistory> answerHistory(@AuthenticationPrincipal TraineeUser traineeUser, @RequestBody MedicalHistory history) {
        var trainee = traineeService.findByCpf(traineeUser.getCpf())
                .orElseThrow(() -> new RuntimeException("Trainee not found"));

        history.setTrainee(trainee);
        history.setStatus(MedicalHistoryStatus.SUBMITTED);

        return ResponseEntity.ok(historyService.save(history));
    }

    // ------------------------ TRAINEE WORKOUT --------------------------

    @GetMapping("/workout/{id}")
    @PreAuthorize("hasRole('TRAINEE')")
    public ResponseEntity<?> getMyWorkout(@PathVariable Long id) {
        return workoutService.getWorkoutForTrainee(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
