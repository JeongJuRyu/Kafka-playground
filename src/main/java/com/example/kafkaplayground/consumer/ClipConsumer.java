package com.example.kafkaplayground.consumer;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class ClipConsumer {
    @KafkaListener(id = "clip3-id", topics = "clip3")
    public void listenClip3(String message){
        System.out.println(message);
    }

    @KafkaListener(id = "clip3-id2", topics = "clip3-bytes")
    public void listenClip3Bytes(String message){
        System.out.println(message);
    }
}
