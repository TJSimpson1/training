package com.fdmgroup.json.example2;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Trainee {
	private String name;
	private String stream;
	private Academy academy;
	private boolean signedOff;
	
	@JsonCreator
	public Trainee(@JsonProperty("name") String name, @JsonProperty("stream") String stream, @JsonProperty("academy") Academy academy, @JsonProperty("signedOff") boolean signedOff) {
		super();
		this.name = name;
		this.stream = stream;
		this.academy = academy;
		this.signedOff = signedOff;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getStream() {
		return stream;
	}
	public void setStream(String stream) {
		this.stream = stream;
	}
	public Academy getAcademy() {
		return academy;
	}
	public void setAcademy(Academy academy) {
		this.academy = academy;
	}
	public boolean isSignedOff() {
		return signedOff;
	}
	public void setSignedOff(boolean signedOff) {
		this.signedOff = signedOff;
	}
	
}
