package com.infnet.fitcoach_saas.controller;

import com.infnet.fitcoach_saas.models.Trainee;
import com.infnet.fitcoach_saas.service.TraineeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/trainee")
public class TraineeController {
    private final TraineeService service;

    public TraineeController(TraineeService service){
        this.service = service;
    }

    @PostMapping()
    public ResponseEntity<Trainee> create(@RequestBody Trainee trainee){
        return ResponseEntity.ok(service.save(trainee));
    }

    @GetMapping
    public ResponseEntity<List<Trainee>> getAll(){
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Trainee> getById(@PathVariable Long id){
        return service.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
