package com.infnet.fitcoach_saas.controller;

import com.infnet.fitcoach_saas.models.Anamnese;
import com.infnet.fitcoach_saas.service.AnamneseService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/anamnese")
public class AnamneseController {
    private final AnamneseService service;

    public AnamneseController(AnamneseService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Anamnese> create(@RequestBody Anamnese anamnese) {
        return ResponseEntity.ok(service.save(anamnese));
    }

    @GetMapping("/trainee/{traineeId}")
    public ResponseEntity<Anamnese> getByTrainee(@PathVariable Long traineeId) {
        return service.findByTraineeId(traineeId)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
