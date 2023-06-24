package com.fdmgroup.designPatterns.objectPool;

import java.util.ArrayList;
import java.util.List;

public class ConnectionPool {

	private List<Connection> availableConnections = new ArrayList<>();
	private List<Connection> usedConnections = new ArrayList<>();
	
	private int minConnections;
	private int maxConnections;
	
	
	public ConnectionPool(int minConnections, int maxConnections) {
		this.minConnections = minConnections;
		this.maxConnections = maxConnections;
		
		for (int numberOfConnections = 1; numberOfConnections <= minConnections; numberOfConnections ++) {
			availableConnections.add(new Connection(numberOfConnections));
		}
	}
	
	public Connection borrowConnection() {
		Connection connection = null;
		
		if (availableConnections.size() > 0) {
			connection = availableConnections.get(0);
			availableConnections.remove(0);
		} else if (usedConnections.size() < maxConnections) {
			connection = new Connection(usedConnections.size()+1);
		}
		
		usedConnections.add(connection);
		
		return connection;
	}
	
	public void returnConnection(Connection connection) {
		usedConnections.remove(connection);
		availableConnections.add(connection);
	}


	public int getMinConnections() {
		return minConnections;
	}


	public void setMinConnections(int minConnections) {
		this.minConnections = minConnections;
	}


	public int getMaxConnections() {
		return maxConnections;
	}


	public void setMaxConnections(int maxConnections) {
		this.maxConnections = maxConnections;
	}
	
	
	
}
