package com.grv.kafkabinderexample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.util.function.Consumer;
import java.util.function.Supplier;


@SpringBootApplication
@EnableScheduling
public class KafkaBinderExampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(KafkaBinderExampleApplication.class, args);
	}


//	@Bean
//	public Consumer<String> consumer() {
//		return message -> System.out.println("received " + message);
//	}

//	@Bean
//	public Supplier<String> producer() {
//		return () -> " First Message";
//	}
}
