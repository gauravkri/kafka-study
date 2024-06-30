package com.grv.kafka_producer_example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.util.function.Consumer;

@SpringBootApplication
@EnableScheduling
public class KafkaProducerExampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(KafkaProducerExampleApplication.class, args);
	}

}
