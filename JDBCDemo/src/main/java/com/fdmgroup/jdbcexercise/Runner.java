package com.fdmgroup.jdbcexercise;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import com.fdmgroup.jdbcexercise.dao.UsersDAO;
import com.fdmgroup.jdbcexercise.dao.UsersDAOImpl;
import com.fdmgroup.jdbcexercise.model.User;

public class Runner {

	public static void main(String[] args) {
		UsersDAO usersDao = new UsersDAOImpl();
		
		try {
			DriverManager.registerDriver(new org.h2.Driver());
			
			System.out.println("========== PHASE 2: ListUsers ==========");
			
			List<User> foundUsers = usersDao.listUsers();
			
			for(User eachUser : foundUsers) {
				System.out.println(eachUser);
			}
			
			System.out.println("\n========== PHASE 3: GetUser ==========");
			
			User user = usersDao.getUser("my-precious");
			System.out.println(user);
			
			System.out.println("\n========== PHASE 4: RemoveUser ==========");
			
			usersDao.removeUser("dog-lover");
			List<User> foundUsersAfterRemoval = usersDao.listUsers();
			for(User eachUser : foundUsersAfterRemoval) {
				System.out.println(eachUser);
			}
			
			System.out.println("\n========== PHASE 5: AddUser ==========");
			User userToAdd = new User();
			userToAdd.setUsername("dog-lover");
			userToAdd.setFirstName("John");
			userToAdd.setLastName("Wick");
			userToAdd.setPassword("puppies");
			userToAdd.setEmail("johny-loves-dogs@hightable.com");
			
			usersDao.addUser(userToAdd);
			List<User> foundUsersAfterAddition = usersDao.listUsers();
			for(User eachUser : foundUsersAfterAddition) {
				System.out.println(eachUser);
			}
			
			System.out.println("\n========== PHASE 5.1: UpdateUser ==========");
			User userToUpdate = new User();
			userToUpdate.setUsername("best-hobbit-friend-ever");
			userToUpdate.setFirstName("Merry");
			userToUpdate.setLastName("Brandybuck");
			userToUpdate.setPassword("breakfast");
			userToUpdate.setEmail("merryb@theshire.com");
			
			usersDao.updateUser(userToUpdate);
			List<User> foundUsersAfterUpdate = usersDao.listUsers();
			for(User eachUser : foundUsersAfterUpdate) {
				System.out.println(eachUser);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
	
	public static void generateTableAndValues() {
		String url = "jdbc:h2:file:c:\\h2\\jdbc-exercise-db";
		String user = "sa";
		String pass = "";
		try {
			Connection conn = DriverManager.getConnection(url, user, pass);
			Statement stmt = conn.createStatement();
			
			//creating table
			stmt.execute("CREATE TABLE users (username VARCHAR2(25), first_name VARCHAR2(25), last_name VARCHAR2(25), password VARCHAR2(25), email VARCHAR2(50))");
			
			//adding users to the table
			stmt.executeUpdate("INSERT INTO users (username, first_name, last_name, password, email) VALUES ('dog-lover', 'John', 'Wick', 'puppies', 'johny-loves-dogs@hightable.com')");
			stmt.executeUpdate("INSERT INTO users (username, first_name, last_name, password, email) VALUES ('best-hobbit-friend-ever', 'Samwise', 'Gamgee', 'frodo', 'samGangee@theshire.com')");
			stmt.executeUpdate("INSERT INTO users (username, first_name, last_name, password, email) VALUES ('my-precious', 'Gollum', '???', 'precious', 'not-my-ring@theshire.com')");
			stmt.executeUpdate("INSERT INTO users (username, first_name, last_name, password, email) VALUES ('greatest-son-ever', 'Tyrion', 'Lannister', 'theGreatestLannister', 'tyrion@lannister.com')");
		
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
