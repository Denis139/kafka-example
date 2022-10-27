package com.kafkaexample.controller;

import lombok.Data;

import java.util.UUID;

@Data
public class MessageRequest {

    private String message;
    private UUID id;
    private String data;

}
