package com.fdmgroup.jdbcexercise.dao;

import java.util.List;

import com.fdmgroup.jdbcexercise.model.User;

public interface UsersDAO {
	void addUser(User user);
	User getUser(String username);
	void removeUser(String username);
	void updateUser(User user);
	List<User> listUsers();
}
