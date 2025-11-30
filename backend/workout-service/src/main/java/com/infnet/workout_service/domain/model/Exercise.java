package com.infnet.workout_service.domain.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "exercises")
public class Exercise {
    @Id
    private String id;
    private String name;
    private String description;
    private String muscleGroup;
    private String level;
    private String videoUrl;
    private String equipment;

    public Exercise() {}

    public Exercise(String name, String description, String muscleGroup, String level, String videoUrl, String equipment) {
        this.name = name;
        this.description = description;
        this.muscleGroup = muscleGroup;
        this.level = level;
        this.videoUrl = videoUrl;
        this.equipment = equipment;
    }

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    public String getMuscleGroup() { return muscleGroup; }
    public void setMuscleGroup(String muscleGroup) { this.muscleGroup = muscleGroup; }
    public String getLevel() { return level; }
    public void setLevel(String level) { this.level = level; }
    public String getVideoUrl() { return videoUrl; }
    public void setVideoUrl(String videoUrl) { this.videoUrl = videoUrl; }
    public String getEquipment() { return equipment; }
    public void setEquipment(String equipment) { this.equipment = equipment; }
}
