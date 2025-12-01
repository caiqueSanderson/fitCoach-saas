package com.infnet.main_service.controller;

import com.infnet.main_service.models.MedicalHistory;
import com.infnet.main_service.service.AssignedWorkoutService;
import com.infnet.main_service.service.MedicalHistoryService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/trainee")
public class TraineeController {
    private final MedicalHistoryService historyService;
    private final AssignedWorkoutService workoutService;

    public TraineeController(
            MedicalHistoryService historyService,
            AssignedWorkoutService workoutService
    ) {
        this.historyService = historyService;
        this.workoutService = workoutService;
    }

    // ------------------------ MEDICAL HISTORY --------------------------

    @PostMapping("/history/{id}")
    @PreAuthorize("hasRole('TRAINEE')")
    public ResponseEntity<MedicalHistory> answerHistory(@RequestBody MedicalHistory history) {
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
