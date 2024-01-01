package com.grv.kafkabinderexample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class KafkaProducer {

    @Autowired
    private StreamBridge streamBridge;

//    @Scheduled(cron = "*/2 * * * * *")
    public void sendMessage(){
        System.out.println("this scheduler ");
        streamBridge.send("producer-out-0","this is scheduler message");
    }

    public void sendMessage(String message){
        System.out.println("this rest call  ");
        streamBridge.send("producer-out-0",message);
    }
}
