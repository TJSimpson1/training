package com.fdmgroup.bookclient.service;

import java.util.List;

import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.ExchangeFilterFunction;
import org.springframework.web.reactive.function.client.WebClient;

import com.fdmgroup.bookclient.exception.WebClientExceptionFilter;
import com.fdmgroup.bookclient.model.Book;

@Service
public class WebClientBookService {

	private final WebClient webClient;
	private final String REST_API_URL = "http://localhost:8088/api/v1/books/";
	private ExchangeFilterFunction responseFilter =
			ExchangeFilterFunction.ofResponseProcessor(WebClientExceptionFilter::filterResponseFunction);

	public WebClientBookService(WebClient.Builder builder) {
		super();
		this.webClient = builder
				.baseUrl(REST_API_URL)
				.filter(responseFilter)
				.defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
				.build();
	}
	
	public List<Book> getAllBooks() {
		return webClient.get()
				.retrieve()
				.bodyToFlux(Book.class) // => 1..n values
				.collectList()
				.block();
	}

	public Book getBookById(int id) {
		return webClient.get()
				.uri(builder -> builder.path("{id}").build(id))
				.retrieve()
				.bodyToMono(Book.class) // => 0..1 values
				.block();
	}

	public Book updateBook(Book book, int id) {
		return webClient.put()
				.uri(builder -> builder.path("{id}").build(id))
				.bodyValue(book)
				.retrieve()
				.bodyToMono(Book.class)
				.block();
	}

	public Book addBook(Book book) {
		return webClient.post()
				.bodyValue(book)
				.retrieve()
				.bodyToMono(Book.class)
				.block();
	}
	
	public void deleteBook(int id) {
		webClient.delete()
			.uri(builder -> builder.path("{id}").build(id))
			.retrieve()
			.toBodilessEntity()
			.block();
	}	
	
}
