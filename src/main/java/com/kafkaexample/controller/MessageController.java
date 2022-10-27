package com.kafkaexample.controller;

import lombok.RequiredArgsConstructor;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.UUID;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequiredArgsConstructor
public class MessageController {

    private final KafkaTemplate<String, MessageRequest> kafkaTemplate;

    @PostMapping(value = "/test", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public void publish(@RequestBody MessageRequest request) {
        var producerRecord = new ProducerRecord<>("FirstKafka", UUID.randomUUID().toString(), request);

        kafkaTemplate.send(producerRecord);
    }
}