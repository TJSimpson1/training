package com.fdmgroup.jdbcdemo;

public class Broker {
	private int broker_id;
	private String first_name;
	private String last_name;
	
	public int getBroker_id() {
		return broker_id;
	}
	public void setBroker_id(int broker_id) {
		this.broker_id = broker_id;
	}
	public String getFirst_name() {
		return first_name;
	}
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	public String getLast_name() {
		return last_name;
	}
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	
	@Override
	public String toString() {
		return "Broker [broker_id=" + broker_id + ", first_name=" + first_name + ", last_name=" + last_name + "]";
	}
	
	
	
	
}
