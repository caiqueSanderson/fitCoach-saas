package com.infnet.main_service.controller;

import com.infnet.main_service.models.MedicalHistory;
import com.infnet.main_service.models.Trainee;
import com.infnet.main_service.service.AssignedWorkoutService;
import com.infnet.main_service.service.MedicalHistoryService;
import com.infnet.main_service.service.TraineeService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/instructor")
public class InstructorController {
    private final TraineeService traineeService;
    private final MedicalHistoryService historyService;
    private final AssignedWorkoutService workoutService;

    public InstructorController(
            TraineeService traineeService,
            MedicalHistoryService historyService,
            AssignedWorkoutService workoutService
    ) {
        this.traineeService = traineeService;
        this.historyService = historyService;
        this.workoutService = workoutService;
    }

    // ------------------------ TRAINEE --------------------------

    @PostMapping("/trainee")
    @PreAuthorize("hasRole('INSTRUCTOR')")
    public ResponseEntity<Trainee> createTrainee(@RequestBody Trainee trainee) {
        Trainee created = traineeService.save(trainee);
        return ResponseEntity
                .created(URI.create("/instructor/trainee/" + created.getCpf()))
                .body(created);
    }

    @GetMapping("/trainee")
    @PreAuthorize("hasRole('INSTRUCTOR')")
    public ResponseEntity<List<Trainee>> getAllTrainees() {
        return ResponseEntity.ok(traineeService.findAll());
    }

    @GetMapping("/trainee/{id}")
    @PreAuthorize("hasRole('INSTRUCTOR')")
    public ResponseEntity<Trainee> getTrainee(@PathVariable Long id) {
        return traineeService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // ------------------------ MEDICAL HISTORY --------------------------

    @GetMapping("/history/{id}")
    @PreAuthorize("hasRole('INSTRUCTOR')")
    public ResponseEntity<MedicalHistory> getMedicalHistory(@PathVariable Long id) {
        return historyService.findByTraineeId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // ------------------------ WORKOUT ASSIGN --------------------------

    @PostMapping("/assign-workout")
    @PreAuthorize("hasRole('INSTRUCTOR')")
    public ResponseEntity<?> assignWorkout(
            @RequestParam Long traineeId,
            @RequestParam String workoutId
    ) {
        return ResponseEntity.ok(workoutService.assignWorkout(traineeId, workoutId));
    }

    @GetMapping("/workout/{id}")
    @PreAuthorize("hasRole('INSTRUCTOR')")
    public ResponseEntity<?> getWorkoutOfTrainee(@PathVariable Long id) {
        return workoutService.getWorkoutForTrainee(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
