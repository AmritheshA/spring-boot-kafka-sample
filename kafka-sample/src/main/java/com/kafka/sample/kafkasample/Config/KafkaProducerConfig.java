package com.kafka.sample.kafkasample.Config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class KafkaProducerConfig {

    @Bean
    public NewTopic createCustomTopics(){
        return new NewTopic("Sample-Topic-2",5,(short) 1);
    }

}
