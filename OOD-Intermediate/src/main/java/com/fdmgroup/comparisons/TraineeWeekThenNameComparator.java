package com.fdmgroup.comparisons;

import java.util.Comparator;

public class TraineeWeekThenNameComparator implements Comparator<Trainee> {

	@Override
	public int compare(Trainee trainee1, Trainee trainee2) {
		if(trainee1.getWeek().equals(trainee2.getWeek())) {
			return trainee1.getName().compareTo(trainee2.getName());
		}
		return trainee1.getWeek().compareTo(trainee2.getWeek());
	}

}
