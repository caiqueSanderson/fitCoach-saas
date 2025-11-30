package com.infnet.workout_service.infra.persistence;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "exercises")
public class ExerciseDocument {
    @Id
    private String id;
    private String name;
    private String description;
    private List<String> muscleGroup;
    private List<String> equipment;
    private String videoUrl;
    private List<String> tags;
}
