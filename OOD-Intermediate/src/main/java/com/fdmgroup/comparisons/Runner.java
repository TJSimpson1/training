package com.fdmgroup.comparisons;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class Runner {

	public static void main(String[] args) {
		Trainee trainee1 = new Trainee("Tom", 4, 78.9);
		Trainee trainee2 = new Trainee("Jane", 12, 98.2);
		Trainee trainee3 = new Trainee("Bob", 9, 65.3);
		
		List<Trainee> trainees  = new ArrayList<>(Arrays.asList(trainee1, trainee2, trainee3));
		
		//Collections.sort(trainees);
		//Collections.sort(trainees, new TraineeWeekComparator());
		//Collections.sort(trainees, new TraineeScoreComparator());
		Collections.sort(trainees, new TraineeWeekThenNameComparator());
		
//		for(Trainee trainee : trainees) {
//			System.out.println(trainee.getName() + " week: " + trainee.getWeek() + " score: " + trainee.getAverageExamScore());
//		}
		Set<Trainee> traineesByWeek = new TreeSet<>(new TraineeWeekComparator());
//		Set<Trainee> traineesByWeek = new TreeSet<>(); //Would sort by name by default as this is defined in the comparable in Trainee class
		traineesByWeek.add(trainee1);
		traineesByWeek.add(trainee2);
		traineesByWeek.add(trainee3);
		
		for(Trainee trainee : traineesByWeek) {
			System.out.println(trainee.getName() + " week: " + trainee.getWeek() + " score: " + trainee.getAverageExamScore());
		}
		
		
		
	}

}
