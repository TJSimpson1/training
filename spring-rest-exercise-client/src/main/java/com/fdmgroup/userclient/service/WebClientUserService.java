package com.fdmgroup.userclient.service;

import java.util.List;

import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.ExchangeFilterFunction;
import org.springframework.web.reactive.function.client.WebClient;

import com.fdmgroup.userclient.exception.WebClientExceptionFilter;
import com.fdmgroup.userclient.model.User;

@Service
public class WebClientUserService {
	
	private final WebClient webClient;
	private final String REST_API_URL = "http://localhost:8088/api/v1/users/";
	private ExchangeFilterFunction responseFilter = 
			ExchangeFilterFunction.ofResponseProcessor(WebClientExceptionFilter::filterResponseFunction);
	
	public WebClientUserService(WebClient.Builder builder) {
		super();
		this.webClient = builder
				.baseUrl(REST_API_URL)
				.filter(responseFilter)
				.defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
				.build();
	}

	public User getUserByUsername(String username) {
		return webClient.get()
				.uri(builder -> builder.path("username/{username}").build(username))
				.retrieve()
				.bodyToMono(User.class)
				.block();
	}

	public boolean verifyPassword(String username, String password) {
		User user = getUserByUsername(username);
		return user.getPassword().equals(password);	
	}

	public User addUser(User user) {
		return webClient.post()
				.bodyValue(user)
				.retrieve()
				.bodyToMono(User.class)
				.block();
	}

	public List<User> getAllUsers() {
		return webClient.get()
				.retrieve()
				.bodyToFlux(User.class)
				.collectList()
				.block();
	}

	
	
}
