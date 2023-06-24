package com.fdmgroup.comparisons;

import java.util.Comparator;

public class TraineeScoreComparator implements Comparator<Trainee> {

	@Override
	public int compare(Trainee trainee1, Trainee trainee2) {
		return ((Double) trainee2.getAverageExamScore()).compareTo(trainee1.getAverageExamScore()); //Flip order to get ascending/descending
	}

}
