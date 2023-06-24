package com.fdmgroup.dependencies;

import java.util.ArrayList;
import java.util.List;

public class Classroom {
	private Trainer trainer;
	private String name;
	private List<Trainee> trainees = new ArrayList<Trainee>();
	private int capacity;
	
	public Classroom(String name) {
		super();
		this.name = name;
	}
	
	public void addTrainee(Trainee trainee) {
		if(trainees.size() < capacity) {
			trainees.add(trainee);
		}	
	}
	
	public void removeTrainee(Trainee trainee) {
		if(trainees.contains(trainee)) {
			trainees.remove(trainee);
		}
	}
	
	
	
	public List<Trainee> getTrainees() {
		return trainees;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public Trainer getTrainer() {
		return trainer;
	}
	public void setTrainer(Trainer trainer) {
		this.trainer = trainer;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	

}
