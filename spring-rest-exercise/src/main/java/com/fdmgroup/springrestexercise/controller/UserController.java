package com.fdmgroup.springrestexercise.controller;

import java.net.URI;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.fdmgroup.springrestexercise.exception.ResourceNotFoundException;
import com.fdmgroup.springrestexercise.model.User;
import com.fdmgroup.springrestexercise.service.UserService;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {

	private final UserService userService;

	public UserController(UserService userService) {
		super();
		this.userService = userService;
	}
	
	@GetMapping
	public ResponseEntity<List<User>> getUsers() {
		return ResponseEntity
				.ok(userService.getAllBooks());
	}
	
	@GetMapping("/id/{id}")
	public ResponseEntity<User> getUserById(@PathVariable int id) {
		return ResponseEntity
				.status(HttpStatus.OK)
				.body(userService.getUserById(id));
	}
	
	@GetMapping("/username/{username}")
	public ResponseEntity<User> getUserByName(@PathVariable String username) {
		return ResponseEntity
				.status(HttpStatus.OK)
				.body(userService.getUserByUsername(username));
	}
	
	@PostMapping
	public ResponseEntity<User> createUser(@RequestBody User user) {
		userService.createUser(user);
		URI location = ServletUriComponentsBuilder
				.fromCurrentRequest()
				.path("/id/{id}")
				.buildAndExpand(user.getId())
				.toUri();
		return ResponseEntity
				.created(location)
				.body(user);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<User> updateUser(@RequestBody User user, @PathVariable int id) {
		return ResponseEntity
				.ok(userService.updateUser(user, id));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteUser(@PathVariable int id) {
		userService.deleteById(id);
		return ResponseEntity
				.status(HttpStatus.OK)
				.build();
	}
	
	@ExceptionHandler(value=ResourceNotFoundException.class)
	public ResponseEntity<String> handleResourceNotFoundException(ResourceNotFoundException ex) {
		return ResponseEntity
				.status(HttpStatus.NOT_FOUND)
				.body(ex.getMessage());
	}
	
	@ExceptionHandler(value=MethodArgumentNotValidException.class)
	public ResponseEntity<String> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex){
		List<ObjectError> errors = ex.getAllErrors();
		errors.get(1).getDefaultMessage();
		StringBuilder stringBuilder = new StringBuilder();
		errors.forEach(error -> stringBuilder.append(error.getDefaultMessage() + ", "));
		return ResponseEntity
				.status(HttpStatus.BAD_REQUEST)
				.body(stringBuilder.toString());
	}
	
}
