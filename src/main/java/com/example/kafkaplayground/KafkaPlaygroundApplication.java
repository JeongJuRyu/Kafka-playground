package com.example.kafkaplayground;

import com.example.kafkaplayground.model.Animal;
import com.example.kafkaplayground.model.CreateOrderDto;
import com.example.kafkaplayground.producer.ClipProducer;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.listener.KafkaMessageListenerContainer;

import java.nio.charset.StandardCharsets;

@SpringBootApplication
public class KafkaPlaygroundApplication {

    public static void main(String[] args) {
        SpringApplication.run(KafkaPlaygroundApplication.class, args);


    }
    @Bean
    public ApplicationRunner runner(ClipProducer clipProducer, KafkaMessageListenerContainer<String, String> kafkaMessageListenerContainer
    ){
        return args -> {
            clipProducer.async("order.create-order", new CreateOrderDto("ryu", 2));
        };
    }

}
