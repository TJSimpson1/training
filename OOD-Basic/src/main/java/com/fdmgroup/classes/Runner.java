package com.fdmgroup.classes;

import java.util.ArrayList;
import java.util.List;

public class Runner {

	public static void main(String[] args) {
		//Creating 2 trainee objects
		Trainee trainee1 = new Trainee("John","Java",-4);
		Trainee trainee2 = new Trainee("Jane",".Net",6);
		
		//Setting trainees' attributes 
//		trainee1.setName("John");
//		trainee1.setStream("Java");
//		trainee1.setWeek(-4);
//		
//		trainee2.setName("Jane");
//		trainee2.setStream(".Net");
//		trainee2.setWeek(6);
		
		//Checking object behaviour
		trainee1.learn();
		trainee2.learn();
		
		int trainee1Result = trainee1.takeExam("TDD");
		int trainee2Result = trainee2.takeExam("Pointers");
		
		System.out.println(trainee1.getNAME() + " has scored " + trainee1Result);
		System.out.println(trainee2.getNAME() + " has scored " + trainee2Result);
		
//		Trainee anotherTrainee1Reference = trainee1;
//		
//		anotherTrainee1Reference.name = "Bob";
//		
//		System.out.println(trainee1.name);
//		
//		List<Trainee> trainees = new ArrayList<Trainee>();
//		trainees.add(trainee1);
//		trainees.add(trainee2);
//		
//		System.out.println(trainees.get(0).name);
	}

}
