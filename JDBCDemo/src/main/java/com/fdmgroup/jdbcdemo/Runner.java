package com.fdmgroup.jdbcdemo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Runner {

	public static void main(String[] args) {
		try {
			//Step 1: Registering the driver
			DriverManager.registerDriver(new org.h2.Driver());
			
			//Step 2: Get a connection object
			Connection conn = DriverManager.getConnection("jdbc:h2:file:c:\\h2\\jdbcdb", "sa", "");
			System.out.println("Connected to the H2 Database");
			
			Statement stmt = conn.createStatement();
			
			String queryToCreateBrokerTable = 
					"CREATE TABLE brokers (broker_id NUMBER(6), first_name VARCHAR2(25), last_name VARCHAR2(25))";
			
			//stmt.execute(queryToCreateBrokerTable);
			
			
			
			
			
			String insertBroker1 = 
					"INSERT INTO brokers (broker_id, first_name, last_name) VALUES (1, 'John', 'Smith')"; 
			//stmt.executeUpdate(insertBroker1);
			
			String insertBroker2 = 
					"INSERT INTO brokers (broker_id, first_name, last_name) VALUES (2, 'Sumaira', 'Amiri')"; 
			//stmt.executeUpdate(insertBroker2);
			
			
			
			
			
			ResultSet rs = stmt.executeQuery("SELECT broker_id, first_name, last_name FROM brokers");
			
			while(rs.next()) {
				Integer id = rs.getInt("broker_id");
				if(rs.wasNull()) {
					id = 0;
				}
				String firstName = rs.getString(2);
				String lastName = rs.getString(3);
				System.out.println(id + " : " + firstName + " " + lastName);
			}
			
			
			System.out.println("==========Finding broker by first name==========");
			
			Broker brokerFound = findBrokerByFirstName("Sumaira", conn);
			System.out.println(brokerFound);
			
			
			conn.close();
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	
	public static Broker findBrokerByFirstName(String firstName, Connection conn) {
		String findBrokerByFirstNameQuery = 
				"SELECT broker_id, first_name, last_name FROM brokers WHERE first_name = ?";
		List<Broker> brokersFound = new ArrayList<Broker>();
		
		
		try {
			PreparedStatement pstmt = conn.prepareStatement(findBrokerByFirstNameQuery);
			pstmt.setString(1, firstName);
			
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				Broker broker = new Broker();
				broker.setBroker_id(rs.getInt(1));
				broker.setFirst_name(rs.getString(2));
				broker.setLast_name(rs.getString(3));
				
				brokersFound.add(broker);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return brokersFound.get(0);
	}
	

}
