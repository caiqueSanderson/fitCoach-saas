package com.infnet.main_service.clients;

import com.infnet.main_service.clients.dto.WorkoutDTO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class WorkoutClientService {
    private final RestTemplate restTemplate;
    private final String baseUrl;

    public WorkoutClientService(RestTemplate restTemplate,
                                @Value("${clients.workout-service.url:http://workout-service:8081}") String baseUrl) {
        this.restTemplate = restTemplate;
        this.baseUrl = baseUrl;
    }

    public List<WorkoutDTO> listAllWorkouts(){
        String url = baseUrl + "/api/workouts";
        ResponseEntity<WorkoutDTO[]> resp = restTemplate.getForEntity(url, WorkoutDTO[].class);
        WorkoutDTO[] body = resp.getBody();
        return body == null ? List.of() : Arrays.asList(body);
    }

    public Optional<WorkoutDTO> getWorkoutById(String id){
        String url = baseUrl + "/api/workouts/" + id;
        try {
            ResponseEntity<WorkoutDTO> resp = restTemplate.getForEntity(url, WorkoutDTO.class);
            return Optional.ofNullable(resp.getBody());
        } catch (Exception ex){
            return Optional.empty();
        }
    }

    public WorkoutDTO createWorkout(WorkoutDTO payload){
        String url = baseUrl + "/api/workouts";
        return restTemplate.postForObject(url, payload, WorkoutDTO.class);
    }
}
