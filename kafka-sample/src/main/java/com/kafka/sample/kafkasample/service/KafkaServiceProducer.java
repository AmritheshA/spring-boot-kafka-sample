package com.kafka.sample.kafkasample.service;

import org.apache.kafka.common.protocol.types.Field;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Service
public class KafkaServiceProducer {

    @Autowired
    private KafkaTemplate<String,Object> kafkaTemplate;

    public void sendMessageToTopics(String message){
        CompletableFuture<SendResult<String, Object>> future = kafkaTemplate.send("sampleTopic-1", message);
        future.whenComplete((result,exception) -> {
            if(exception == null){
                System.out.println("Sent Message[" +message+"] with offset ["+result.getRecordMetadata().offset()+"]");
            }else{
                System.out.println("Unable to send message ["+message+"] due to  "+exception.getMessage());
            }
        });
    }

}
