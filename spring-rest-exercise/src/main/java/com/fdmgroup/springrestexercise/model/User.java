package com.fdmgroup.springrestexercise.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name="user_table")
public class User {
	
	@Id
	@GeneratedValue
	private int id;
	@NotBlank(message="First name must not be blank")
	private String firstName;
	@NotBlank(message="Last name must not be blank")
	private String lastName;
	@NotBlank(message="Username must not be blank")
	@Size(min=2, max=25, message="Username must be between 2-25 characters")
	private String username;
	@NotBlank(message="Password must not be blank")
	@Size(min=6, max=25, message="Password must be between 6-25 characters")
	private String password;
	
	public User() {
		super();
	}

	public User(int id, String firstName, String lastName, String username, String password) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.username = username;
		this.password = password;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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
	
	

}
