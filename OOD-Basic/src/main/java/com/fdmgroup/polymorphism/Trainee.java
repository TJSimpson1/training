package com.fdmgroup.polymorphism;

import java.util.Objects;

public class Trainee {
	private String name;
	private String stream;
	private int week;
	
	public Trainee(String name, String stream, int week) {
		super();
		this.name = name;
		this.stream = stream;
		this.week = week;
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
	public int getWeek() {
		return week;
	}
	public void setWeek(int week) {
		this.week = week;
	}
	@Override
	public int hashCode() {
		return Objects.hash(name, stream, week);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Trainee other = (Trainee) obj;
		return Objects.equals(name, other.name) && Objects.equals(stream, other.stream) && week == other.week;
	}
	
	@Override
	public String toString() {
		return "Trainee [name=" + name + ", stream=" + stream + ", week=" + week + "]";
	}
	
	
	
	
	
	
}
