package com.infnet.fitcoach_saas.controller;

import com.infnet.fitcoach_saas.models.MedicalHistory;
import com.infnet.fitcoach_saas.service.MedicalHistoryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/history")
public class MedicalHistoryController {
    private final MedicalHistoryService service;

    public MedicalHistoryController(MedicalHistoryService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<MedicalHistory> create(@RequestBody MedicalHistory medicalHistory) {
        return ResponseEntity.ok(service.save(medicalHistory));
    }

    @GetMapping("/trainee/{traineeId}")
    public ResponseEntity<MedicalHistory> getByTrainee(@PathVariable Long traineeId) {
        return service.findByTraineeId(traineeId)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
