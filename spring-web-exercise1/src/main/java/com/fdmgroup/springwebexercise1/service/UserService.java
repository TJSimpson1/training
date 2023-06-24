package com.fdmgroup.springwebexercise1.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fdmgroup.springwebexercise1.model.User;
import com.fdmgroup.springwebexercise1.repository.UserDAO;

@Service
public class UserService {
	
	private UserDAO userDao;
	
	@Autowired
	public UserService(UserDAO userDao) {
		super();
		this.userDao = userDao;
	}
	
	public User addUser(User user) {
		// Check user doesn't already exist and do nothing if they do already exist
		if(user.getPassword().equals("") || userDao.existsByUsername(user.getUsername())) {
			return null;
		}
		System.out.println("Saving " + user.getUsername());
		return userDao.save(user);
	}
	
	public User getUser(String username) {
		Optional<User> optionalUser = userDao.findByUsername(username);
		
		if(optionalUser.isPresent()) {
			return optionalUser.get();
		}
		return null;
	}
	
	public User updateUser(User user) {
		if(!user.getPassword().equals("") && userDao.existsByUsername(user.getUsername())) {
			userDao.save(user);
			return user;
		}
		return null;
	}
	
	public void deleteUser(String username) {
		userDao.deleteByUsername(username);
	}
	
	public List<User> listUsers(){
		return userDao.findAll();
	}

}
