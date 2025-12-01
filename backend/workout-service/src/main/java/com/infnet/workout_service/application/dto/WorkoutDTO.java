package com.infnet.workout_service.application.dto;

import java.util.List;

public class WorkoutDTO {
    private String id;
    private String name;
    private String goal;
    private List<WorkoutExerciseDTO> exercises;
    private String notes;

    public WorkoutDTO() {}

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getGoal() { return goal; }
    public void setGoal(String goal) { this.goal = goal; }

    public List<WorkoutExerciseDTO> getExercises() { return exercises; }
    public void setExercises(List<WorkoutExerciseDTO> exercises) { this.exercises = exercises; }

    public String getNotes() { return notes; }
    public void setNotes(String notes) { this.notes = notes; }

    public static class WorkoutExerciseDTO {
        private String exerciseId;
        private int sets;
        private int reps;
        private int restSeconds;

        public WorkoutExerciseDTO() {}

        public String getExerciseId() { return exerciseId; }
        public void setExerciseId(String exerciseId) { this.exerciseId = exerciseId; }

        public int getSets() { return sets; }
        public void setSets(int sets) { this.sets = sets; }

        public int getReps() { return reps; }
        public void setReps(int reps) { this.reps = reps; }

        public int getRestSeconds() { return restSeconds; }
        public void setRestSeconds(int restSeconds) { this.restSeconds = restSeconds; }
    }
}
