package com.kafkaexample.consumer;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.kafkaexample.controller.MessageRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.juli.logging.Log;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class SimpleConsumer {

    private  final ObjectMapper objectMapper;

    @KafkaListener(topics = "FirstKafka", groupId = "groupId")
    public void listener(ConsumerRecord<String, String> message) {

        log.info("Я принимаю Key "+ message.key());
        log.info("Я принимаю Message " + message.value());
        //log.info("Я преобразовываю Message до объекта" + toObject(message.value(), MessageRequest.class));


    }

    public <D> D toObject(String value, Class<D> clazz) {
        try {
            return objectMapper.readValue(value, clazz);
        } catch (Exception e) {
            log.error("Unsuccessfully conversion of value to {}, error: {}", clazz, e.getMessage());
            throw new RuntimeException(String.format("Unsuccessfully conversion of value to [%s], error: %s", clazz, e.getMessage()));
        }
    }
}
