package com.fdmgroup.springcoredemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.fdmgroup.springcoredemo.controller.BookController;

@SpringBootApplication
public class SpringCoreDemoApplication {

	public static void main(String[] args) {
		//SpringApplication.run(SpringCoreDemoApplication.class, args);
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
		
		BookController bookController = context.getBean("bookController", BookController.class);
		
		bookController.addNewbook(1, "Java for dummies", "John Smith", "Technical",-19.99);
		bookController.addNewbook(1, "Java for dummies", "John Smith", "Technical",19.99);
		bookController.addNewbook(1, "Java for dummies", "John Smith", "Technical",19.99);

		
	}

}
