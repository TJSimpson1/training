package com.fdmgroup.userclient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.function.client.WebClient;

@SpringBootApplication
public class SpringRestExerciseClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringRestExerciseClientApplication.class, args);
	}
	
	@Bean
	WebClient.Builder builder(){
		return WebClient.builder();
	}

}
