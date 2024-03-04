package com.kafka.sample.kafkasampleconsumer.Consumer;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumer {


    @KafkaListener(topics = "sampleTopic-1", groupId = "sample-group-1")
    public void consumeMessage(String message) {
        System.out.println("Consumed Message From Producer --> " + message);
    }
}
