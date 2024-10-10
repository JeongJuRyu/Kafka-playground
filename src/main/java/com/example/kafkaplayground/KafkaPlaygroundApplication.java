package com.example.kafkaplayground;

import com.example.kafkaplayground.producer.ClipProducer;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.core.KafkaTemplate;

@SpringBootApplication
public class KafkaPlaygroundApplication {

    public static void main(String[] args) {
        SpringApplication.run(KafkaPlaygroundApplication.class, args);


    }
    @Bean
    public ApplicationRunner runner(ClipProducer clipProducer){
        return args -> {
            clipProducer.async("clip3", "Hello, Clip3-async");
            clipProducer.async("clip3", "Hello, Clip3-async");
            clipProducer.sync("clip3", "Hello, Clip3-sync");
            clipProducer.async("clip3", "Hello, Clip3-async");
            Thread.sleep(1000L);
        };
    }

}
