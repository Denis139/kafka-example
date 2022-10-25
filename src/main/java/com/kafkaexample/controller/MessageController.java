package com.kafkaexample.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
public class MessageController {

    private final KafkaTemplate<String,String> kafkaTemplate;

    @Autowired
    public MessageController(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @PostMapping(value = "/test", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public void publish(@RequestBody MessageRequest request) {
        kafkaTemplate.send("FirstKafka", request.message());
    }
}
