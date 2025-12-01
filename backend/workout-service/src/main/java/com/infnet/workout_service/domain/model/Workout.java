package com.infnet.workout_service.domain.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "workouts")
public class Workout {
    @Id
    private String id;
    private String name;
    private String goal;
    private List<WorkoutExercise> exercises;
    private String notes;

    public Workout() {}

    public Workout(String name, String goal, List<WorkoutExercise> exercises, String notes) {
        this.name = name;
        this.goal = goal;
        this.exercises = exercises;
        this.notes = notes;
    }

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getGoal() { return goal; }
    public void setGoal(String goal) { this.goal = goal; }
    public List<WorkoutExercise> getExercises() { return exercises; }
    public void setExercises(List<WorkoutExercise> exercises) { this.exercises = exercises; }
    public String getNotes() { return notes; }
    public void setNotes(String notes) { this.notes = notes; }
}
