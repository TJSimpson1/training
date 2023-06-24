package com.fdmgroup.dependencies;

public class Runner2 {

	public static void main(String[] args) {
		Trainer trainer = new Trainer("Edgar");
		Classroom classroom = new Classroom("Jobs");

		classroom.setTrainer(trainer);
		

	}

}
