package com.fdmgroup.designPatterns.objectPool;

public class Connection {

	private int id;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Connection(int id) {
		super();
		this.id = id;
	}
	
	public void connect(String name) {
		System.out.println("Connecting "+name+" to database using connection "+id);
	}
	
}
