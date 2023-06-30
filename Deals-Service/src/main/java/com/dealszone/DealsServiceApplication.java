package com.dealszone;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class DealsServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(DealsServiceApplication.class, args);
		System.out.println("started...........");
	}

}
