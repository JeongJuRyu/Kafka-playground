package com.example.kafkaplayground.consumer;

import com.example.kafkaplayground.model.Animal;
import com.example.kafkaplayground.model.CreateOrderDto;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.listener.adapter.ConsumerRecordMetadata;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Service;

@Service
public class ClipConsumer {
    @KafkaListener(id = "clip4-listener-id", topics = "clip4-listener")
    public void listen(String message,
                       @Header(KafkaHeaders.RECEIVED_TIMESTAMP) long timestamp,
                       @Header(KafkaHeaders.RECEIVED_PARTITION) int partition,
                       @Header(KafkaHeaders.OFFSET) long offset,
                       ConsumerRecordMetadata metadata){
        System.out.println("Listener . offset= " + metadata.offset() +
                ", partition=" + partition +
                ", timestamp=" + timestamp +
                ", offset=" + offset);

    }

    @KafkaListener(id = "clip4-animal-listener-id", topics = "clip4-animal", containerFactory = "kafkaJsonContainerFactory")
    public void listenAnimal(Animal animal,
                             @Header(KafkaHeaders.RECEIVED_TIMESTAMP) long timestamp,
                             @Header(KafkaHeaders.RECEIVED_PARTITION) int partition,
                             @Header(KafkaHeaders.OFFSET) long offset,
                             ConsumerRecordMetadata metadata){
        System.out.println(animal);
    }

    @KafkaListener(id = "create-order-client", topics = "order.create-order", containerFactory = "kafkaJsonContainerFactory")
    public void createOrder(CreateOrderDto dto,
                            @Header(KafkaHeaders.RECEIVED_TIMESTAMP) long timestamp,
                            @Header(KafkaHeaders.RECEIVED_PARTITION) int partition,
                            @Header(KafkaHeaders.OFFSET) long offset,
                            ConsumerRecordMetadata metadata){
        System.out.println(dto);
    }
//    @KafkaListener(id = "clip3-id", topics = "clip3")
//    public void listenClip3(String message){
//        System.out.println(message);
//    }
//
//    @KafkaListener(id = "clip3-id2", topics = "clip3-bytes")
//    public void listenClip3Bytes(String message){
//        System.out.println(message);
//    }
}
