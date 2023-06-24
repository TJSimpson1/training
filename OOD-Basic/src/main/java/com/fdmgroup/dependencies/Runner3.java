package com.fdmgroup.dependencies;

public class Runner3 {

	public static void main(String[] args) {
		Classroom classroom = new Classroom("Jobs");
		classroom.setCapacity(2);
		Trainee trainee1 = new Trainee("Travis");
		Trainee trainee2 = new Trainee("Jakub");
		Trainee trainee3 = new Trainee("James");
		
		classroom.addTrainee(trainee1);
		classroom.addTrainee(trainee2);
		classroom.addTrainee(trainee3);
		
		for(Trainee trainee : classroom.getTrainees()) {
			System.out.println(trainee.getName());
		}
	}

}
