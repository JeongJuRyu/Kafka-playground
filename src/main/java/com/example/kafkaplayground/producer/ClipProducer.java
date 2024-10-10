package com.example.kafkaplayground.producer;

import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

@Service
@RequiredArgsConstructor
public class ClipProducer {
    private final KafkaTemplate<String, String> kafkaTemplate;

    public void async(String topic,String message){
        CompletableFuture<SendResult<String, String>> future = kafkaTemplate.send(topic, message);
        future.thenAccept(result -> {
            System.out.println(result.getRecordMetadata().offset());
        }).exceptionally(ex -> {
            System.out.println(ex.getMessage());
            return null;
        });
    }

    public void sync(String topic, String message) throws ExecutionException, InterruptedException, TimeoutException {
        CompletableFuture<SendResult<String, String>> future = kafkaTemplate.send(topic, message);
        SendResult<String, String> stringStringSendResult = future.get(10, TimeUnit.SECONDS);
        System.out.println(stringStringSendResult.getProducerRecord().key());
    }
}
