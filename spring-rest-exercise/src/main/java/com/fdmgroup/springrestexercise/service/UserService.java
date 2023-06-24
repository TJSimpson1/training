package com.fdmgroup.springrestexercise.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.fdmgroup.springrestexercise.exception.ResourceNotFoundException;
import com.fdmgroup.springrestexercise.exception.UsernameAlreadyExistsException;
import com.fdmgroup.springrestexercise.model.User;
import com.fdmgroup.springrestexercise.repository.UserRepository;

@Service
public class UserService {
	
	private final UserRepository userRepo;

	public UserService(UserRepository userRepo) {
		super();
		this.userRepo = userRepo;
	}

	public List<User> getAllBooks() {
		return userRepo.findAll();
	}

	public User getUserById(int id) {
		Optional<User> userOpt = userRepo.findById(id);
		if(userOpt.isEmpty()) {
			throw new ResourceNotFoundException(getMessage(id));
		}
		return userOpt.get();
	}

	private String getMessage(int id) {
		return "User with ID: " + id + " not found.";
	}

	public User getUserByUsername(String username) {
		Optional<User> userOpt = userRepo.findByUsername(username);
		if(userOpt.isEmpty()) {
			throw new ResourceNotFoundException("User with username " + username + " not found.");
		}
		return userOpt.get();
	}

	public User createUser(User user) {
		Optional<User> userOpt = userRepo.findByUsername(user.getUsername());
		if(userOpt.isPresent()) {
			throw new UsernameAlreadyExistsException("Username: " + user.getUsername() + " already exists.");
		}
		return userRepo.save(user);
		
	}

	public User updateUser(User user, int id) {
		Optional<User> userOpt = userRepo.findById(id);
		if(userOpt.isEmpty()) {
			throw new ResourceNotFoundException(getMessage(id));
		}
		user.setId(id);
		return userRepo.save(user);
	}
	
	public void deleteById(int id) {
		Optional<User> userOpt = userRepo.findById(id);
		if(userOpt.isEmpty()) {
			throw new ResourceNotFoundException(getMessage(id));
		}
		userRepo.deleteById(id);
		
	}

	

	
}
