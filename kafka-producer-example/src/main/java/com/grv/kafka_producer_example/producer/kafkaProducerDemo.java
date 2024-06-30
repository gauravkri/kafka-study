package com.grv.kafka_producer_example.producer;


import com.grv.kafka_producer_example.config.KafkaTopicConfig;
import jakarta.annotation.PostConstruct;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class kafkaProducerDemo {

    KafkaTemplate<String,String> kafkaTemplate;

    kafkaProducerDemo(KafkaTemplate<String,String> kafkaTemplate){
        this.kafkaTemplate=kafkaTemplate;
    }


    @PostConstruct
    public void producerMessage(){
        kafkaTemplate.send(KafkaTopicConfig.topicName,"{name: 'john', location: 'south'}");
    }

}
