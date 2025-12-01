package com.infnet.workout_service.domain.model;

public class WorkoutExercise {
    private String exerciseId;
    private int sets;
    private int reps;
    private int restSeconds;

    public WorkoutExercise() {}

    public WorkoutExercise(String exerciseId, int sets, int reps, int restSeconds) {
        this.exerciseId = exerciseId;
        this.sets = sets;
        this.reps = reps;
        this.restSeconds = restSeconds;
    }

    public String getExerciseId() { return exerciseId; }
    public void setExerciseId(String exerciseId) { this.exerciseId = exerciseId; }

    public int getSets() { return sets; }
    public void setSets(int sets) { this.sets = sets; }

    public int getReps() { return reps; }
    public void setReps(int reps) { this.reps = reps; }

    public int getRestSeconds() { return restSeconds; }
    public void setRestSeconds(int restSeconds) { this.restSeconds = restSeconds; }
}
