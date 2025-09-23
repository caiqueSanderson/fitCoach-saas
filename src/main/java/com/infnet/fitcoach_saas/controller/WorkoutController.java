package com.infnet.fitcoach_saas.controller;

import com.infnet.fitcoach_saas.models.Workout;
import com.infnet.fitcoach_saas.service.WorkoutService;
import org.hibernate.jdbc.Work;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/workout")
public class WorkoutController {
    private final WorkoutService service;

    public WorkoutController(WorkoutService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Workout> create(@RequestBody Workout workout){
        return ResponseEntity.ok(service.save(workout));
    }

    @GetMapping
    public ResponseEntity<List<Workout>> getAll(){
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/id")
    public ResponseEntity<Workout> getById(@PathVariable Long id){
        return service.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/trainee/{traineeId}")
    public ResponseEntity<List<Workout>> getByTrainee(@PathVariable Long traineeId) {
        return ResponseEntity.ok(service.findByTrainee(traineeId));
    }
}
