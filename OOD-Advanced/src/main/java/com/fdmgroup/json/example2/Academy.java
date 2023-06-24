package com.fdmgroup.json.example2;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Academy {
	private String location;
	private String address;
	private boolean popup;
	
	@JsonCreator
	public Academy(@JsonProperty("location") String location, @JsonProperty("address") String address, @JsonProperty("popup") boolean popup) {
		super();
		this.location = location;
		this.address = address;
		this.popup = popup;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public boolean isPopup() {
		return popup;
	}
	public void setPopup(boolean popup) {
		this.popup = popup;
	}
	
}
