package com.grv.kafkabinderexample.rest;

import com.grv.kafkabinderexample.KafkaProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/")
public class TestController {

    @Autowired
    KafkaProducer kafkaProducer;


    @GetMapping("test/{value}")
    public String test(@PathVariable String value){
        kafkaProducer.sendMessage(value);
        return value;
    }
}
