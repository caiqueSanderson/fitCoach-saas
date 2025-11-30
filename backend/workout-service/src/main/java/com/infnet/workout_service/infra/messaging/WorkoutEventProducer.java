package com.infnet.workout_service.infra.messaging;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class WorkoutEventProducer {
    private final RabbitTemplate rabbitTemplate;

    public WorkoutEventProducer(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void publishWorkoutCreated(String id, String name) {
        Map<String, Object> payload = new HashMap<>();
        payload.put("id", id);
        payload.put("name", name);
        payload.put("eventType", "WORKOUT_CREATED");
        rabbitTemplate.convertAndSend(RabbitConfig.WORKOUT_CREATED_QUEUE, payload);
    }
}
