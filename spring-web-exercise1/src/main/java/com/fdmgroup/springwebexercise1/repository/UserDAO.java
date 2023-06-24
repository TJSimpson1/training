package com.fdmgroup.springwebexercise1.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.fdmgroup.springwebexercise1.model.User;

@Repository
public class UserDAO {
	
	private Map<String,User> users = new HashMap<>();
	
	public User save(User user) {
		users.put(user.getUsername(), user);
		return users.get(user.getUsername());
	}
	
	public Optional<User> findByUsername(String username){
		if(users.containsKey(username)) {
			return Optional.ofNullable(users.get(username));
		}
		return Optional.empty();
	}
	
	public List<User> findAll(){
		return new ArrayList<>(users.values());
	}
	
	public boolean existsByUsername(String username) {
		return users.containsKey(username);
	}
	
	public void deleteByUsername(String username) {
		users.remove(username);
	}

}
