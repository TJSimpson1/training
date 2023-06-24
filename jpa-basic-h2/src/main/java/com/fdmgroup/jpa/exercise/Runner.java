package com.fdmgroup.jpa.exercise;

import java.util.List;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.fdmgroup.jpa.exercise.dao.UserDao;
import com.fdmgroup.jpa.exercise.model.User;

public class Runner {

	public static void main(String[] args) {
		EntityManagerFactory emf = 
				Persistence.createEntityManagerFactory("jpabasic");
		
		UserDao userDao = new UserDao(emf);
		
		User user1 = new User(1, "john.smith", "apple123", "John", "Smith");
		User user2 = new User(2, "jane.doe", "banana456", "Jane", "Doe");
		User user3 = new User(3, "joe.bloggs", "orange789", "Joe", "Bloggs");
//		User user4 = new User(4, "test.user", "password", "Test", "User");
		
		userDao.persist(user1);
		userDao.persist(user2);
		userDao.persist(user3);
		
		List<User> allUsers = userDao.findAll();
		System.out.println(allUsers);
		
		User userFoundByUsername = userDao.findByUsername("jane.doe");
		System.out.println(userFoundByUsername);
		
		user2.setPassword("thisPasswordHasBeenChanged");
		userDao.updateUser(user2);
		System.out.println(userDao.findAll());
		
		userDao.deleteById(3);
		System.out.println(userDao.findAll());
		
		
		
		emf.close();
	}

}
