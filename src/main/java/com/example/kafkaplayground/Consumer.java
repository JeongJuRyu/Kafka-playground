package com.example.kafkaplayground;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class Consumer {

    @KafkaListener(id = "fast-campus-id", topics = "clip3")
    public void listen(String message){
    }
}
