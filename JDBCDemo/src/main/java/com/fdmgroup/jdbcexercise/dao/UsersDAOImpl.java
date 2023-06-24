package com.fdmgroup.jdbcexercise.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.fdmgroup.jdbcexercise.model.User;

public class UsersDAOImpl implements UsersDAO{
	String url = "jdbc:h2:file:c:\\h2\\jdbc-exercise-db";
	String user = "sa";
	String pass = "";

	public void addUser(User newUser) {
		try {
			Connection conn = DriverManager.getConnection(url, user, pass);
			String addNewUserQuery = "INSERT INTO users VALUES (?,?,?,?,?)";
			
			PreparedStatement pstmt = conn.prepareStatement(addNewUserQuery);
			pstmt.setString(1, newUser.getUsername());
			pstmt.setString(2, newUser.getFirstName());
			pstmt.setString(3, newUser.getLastName());
			pstmt.setString(4, newUser.getPassword());
			pstmt.setString(5, newUser.getEmail()); 
			
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	public User getUser(String username) {
		List<User> usersFound = new ArrayList<User>();
		
		try {
			Connection conn = DriverManager.getConnection(url, user, pass);
			String findUserByUsernameQuery = 
					"SELECT username, first_name, last_name, password, email FROM users WHERE username = ?";
			
			PreparedStatement pstmt = conn.prepareStatement(findUserByUsernameQuery);
			pstmt.setString(1, username);
			
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				User user = new User();
				user.setUsername(rs.getString("username"));
				user.setFirstName(rs.getString("first_name"));
				user.setLastName(rs.getString("last_name"));
				user.setPassword(rs.getString("password"));
				user.setEmail(rs.getString("email"));
				
				usersFound.add(user);
			}
			
			conn.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return usersFound.get(0);
	}

	public void removeUser(String username) {
		try {
			Connection conn = DriverManager.getConnection(url, user, pass);
			String removeUserQuery = "DELETE FROM users WHERE username = ?";
			
			PreparedStatement pstmt = conn.prepareStatement(removeUserQuery);
			pstmt.setString(1, username);
			
			pstmt.executeUpdate();
			
			
			
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	public void updateUser(User userToUpdate) {
//		removeUser(userToUpdate.getUsername());
//		addUser(userToUpdate);
		try {
			Connection conn = DriverManager.getConnection(url, user, pass);
			String updateUserQuery = 
					"UPDATE users SET first_name = ?, last_name = ?, password = ?, email = ?, username = ? WHERE username = ?";
			
			PreparedStatement pstmt = conn.prepareStatement(updateUserQuery);
			pstmt.setString(1, userToUpdate.getFirstName());
			pstmt.setString(2, userToUpdate.getLastName());
			pstmt.setString(3, userToUpdate.getPassword());
			pstmt.setString(4, userToUpdate.getEmail());
			pstmt.setString(5, userToUpdate.getUsername());
			pstmt.setString(6, userToUpdate.getUsername());
			
			pstmt.executeUpdate();
			
			
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	public List<User> listUsers() {
		List<User> usersFound = new ArrayList<User>();
		
		try {
			Connection conn = DriverManager.getConnection(url, user, pass);
			Statement stmt = conn.createStatement();
			
			ResultSet rs = stmt.executeQuery("SELECT username, first_name, last_name, password, email FROM users");
			
			while(rs.next()) {
				User user = new User();
				user.setUsername(rs.getString("username"));
				user.setFirstName(rs.getString("first_name"));
				user.setLastName(rs.getString("last_name"));
				user.setPassword(rs.getString("password"));
				user.setEmail(rs.getString("email"));
				
				usersFound.add(user);
			}
			
			conn.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return usersFound;
	}

}
