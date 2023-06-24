package com.fdmgroup.comparisons;

import java.util.Comparator;

public class TraineeWeekComparator implements Comparator<Trainee> {

	@Override
	public int compare(Trainee trainee1, Trainee trainee2) {
		//return trainee1.getWeek().compareTo(trainee2.getWeek()); //Flip order to get descending
		return trainee1.getWeek() - trainee2.getWeek(); //Only works with integers! Flip order to get descending
	}

}
