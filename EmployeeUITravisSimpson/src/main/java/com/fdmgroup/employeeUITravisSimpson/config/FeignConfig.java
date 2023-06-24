package com.fdmgroup.employeeUITravisSimpson.config;

import org.springframework.context.annotation.Bean;

import feign.codec.ErrorDecoder;

public class FeignConfig {

	@Bean
	public ErrorDecoder errorDecoder() {
	    return new RetrieveMessageErrorDecoder();
	}
	
}
