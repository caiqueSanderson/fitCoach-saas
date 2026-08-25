                 fit-net
                    │
       ┌────────────┼────────────┐
       │            │            │
       ▼            ▼            ▼
  PostgreSQL      Main       Workout
                  Service     Service
                                │
                         ┌──────┴──────┐
                         ▼             ▼
                       MongoDB      RabbitMQ



                    fit-net
                       │
          ┌────────────┼─────────────┐
          │            │             │
          ▼            ▼             ▼
    main-postgres  main-service  workout-service
       :5432          :8082          :8081
                                      │
                                ┌─────┴─────┐
                                ▼           ▼
                            workout-mongo workout-rabbit
                              :27017         :5672

                              main-service       : 8082

PostgreSQL         : 5432
workout-service    : 8081
   MongoDB            : 27017
   RabbitMQ           : 5672
Eureka             : 8761  