package com.grv.customanotation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

@SpringBootApplication
@ComponentScan(basePackages = {"com.grv.customanotation","com.grv.kafkabinderexample"})
public class CustomAnotationApplication {

	public static void main(String[] args) {
		SpringApplication.run(CustomAnotationApplication.class, args);
	}

}
