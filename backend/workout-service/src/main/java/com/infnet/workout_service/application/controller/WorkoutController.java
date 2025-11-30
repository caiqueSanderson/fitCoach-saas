package com.infnet.workout_service.application.controller;

import com.infnet.workout_service.application.dto.WorkoutDTO;
import com.infnet.workout_service.service.WorkoutAppService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/workouts")
public class WorkoutController {
    private final WorkoutAppService service;

    public WorkoutController(WorkoutAppService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<WorkoutDTO> create(@RequestBody WorkoutDTO dto) {
        WorkoutDTO created = service.createWorkout(dto);
        return ResponseEntity.created(URI.create("/api/workouts/" + created.getId())).body(created);
    }

    @GetMapping
    public ResponseEntity<List<WorkoutDTO>> list() {
        return ResponseEntity.ok(service.listAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<WorkoutDTO> get(@PathVariable String id) {
        WorkoutDTO dto = service.findById(id);
        if (dto == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(dto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<WorkoutDTO> update(@PathVariable String id, @RequestBody WorkoutDTO dto) {
        WorkoutDTO updated = service.update(id, dto);
        if (updated == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
