package com.fdmgroup.comparisons;

import java.util.Comparator;

public class TraineeWeekDescendingOrder implements Comparator<Trainee> {

	@Override
	public int compare(Trainee trainee1, Trainee trainee2) {
		//return trainee2.getWeek().compareTo(trainee1.getWeek()); //Flip order to get descending
		return trainee2.getWeek() - trainee1.getWeek(); //Only works with integers! Flip order to get descending
	}

}
