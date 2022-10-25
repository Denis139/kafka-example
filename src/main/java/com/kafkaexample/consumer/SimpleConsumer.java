package com.kafkaexample.consumer;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class SimpleConsumer {

    @KafkaListener(topics = "FirstKafka", groupId = "groupId")
    public void listener(String data) {
        System.out.println("Listener received: " + data + " :)");
    }
}
