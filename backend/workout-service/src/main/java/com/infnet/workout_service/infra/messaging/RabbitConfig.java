package com.infnet.workout_service.infra.messaging;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;



@Configuration
public class RabbitConfig {
    public static final String WORKOUT_CREATED_QUEUE = "workout.created";

    @Bean
    public Queue workoutCreatedQueue() {
        return new Queue(WORKOUT_CREATED_QUEUE, true);
    }
}
