package com.grv.kafka_producer_binder_example.producer;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class Producer {

    @Autowired
    private StreamBridge streamBridge;

    private int counter= 0;

    @Scheduled(cron = "*/2 * * * * *")
//    @PostConstruct
    public void produceMessage(){
        if (counter<20) {
            String data = "{name : 'gaurav', work: 'sw'}";
            int partitionKey = 0;
            if (counter % 2 != 0) {
                partitionKey = 1;
            }

            Message<String> message = MessageBuilder.withPayload(data)
                    .setHeader("partitionKey", partitionKey)
                    .build();
            System.out.println("this is produceMessage"+ partitionKey + "  "+message.getPayload());
            streamBridge.send("output-out-0", message);
//            streamBridge.send("output-out-1", message);
            counter++;
        }
    }
}
