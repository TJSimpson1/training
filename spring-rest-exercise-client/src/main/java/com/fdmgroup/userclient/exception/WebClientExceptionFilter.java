package com.fdmgroup.userclient.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.reactive.function.client.ClientResponse;

import reactor.core.publisher.Mono;

public class WebClientExceptionFilter {
	
	private WebClientExceptionFilter() {
		super();
	}
	
	public static Mono<ClientResponse> filterResponseFunction(ClientResponse response){
		HttpStatus status = response.statusCode();
		if(status.equals(HttpStatus.NOT_FOUND) || status.equals(HttpStatus.CONFLICT)) {
			return response.bodyToMono(String.class)
					.flatMap(body -> Mono.error(new GenericUserException(body, status.toString())));
		}
		if(status.equals(HttpStatus.BAD_REQUEST)) {
			return response.bodyToMono(String.class)
					.flatMap(body -> Mono.error(new InvalidUserException(body)));
		}
		return Mono.just(response);
	}

}
