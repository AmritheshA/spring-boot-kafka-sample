package com.kafka.sample.kafkasample.controller;

import com.kafka.sample.kafkasample.service.KafkaServiceProducer;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SampleController {


    private final KafkaServiceProducer kafkaServiceProducer;

    public SampleController(KafkaServiceProducer kafkaServiceProducer) {
        this.kafkaServiceProducer = kafkaServiceProducer;
    }

    @GetMapping("/send-message/{message}")
    public ResponseEntity<?> sendMessage(@PathVariable String message) {
        kafkaServiceProducer.sendMessageToTopics(message);
        return new ResponseEntity<>("Message Sent Successfully", HttpStatus.OK);
    }
}
