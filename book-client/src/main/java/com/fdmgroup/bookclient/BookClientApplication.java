package com.fdmgroup.bookclient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.function.client.WebClient;

@SpringBootApplication
@EnableEurekaClient
public class BookClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookClientApplication.class, args);
	}
	
	@Bean
	WebClient.Builder builder() {
		return WebClient.builder();
	}

}
