package com.fdmgroup.jpa.exercise.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="FDM_USER")
public class User {
	@Id
	@Column(name="USER_ID")
	private int id;
	@Column(name="USERNAME", nullable=false, unique=true)
	private String username;
	@Column(name="PASSWORD", nullable=false)
	private String password;
	@Column(name="FIRST_NAME", nullable=false, updatable=false)
	private String firstName;
	@Column(name="LAST_NAME", nullable=false, updatable=false)
	private String lastName;
	
	public User() {}
	
	public User(int id, String username, String password, String firstName, String lastName) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
	}
	
	public void updateDetails(User user) {
		
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password=" + password + ", firstName=" + firstName
				+ ", lastName=" + lastName + "]";
	}
	
	
	
	
	

}
