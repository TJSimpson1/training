package com.fdmgroup.threadingExercises.exercise3;

public class AverageCalculator {
	private long total;
	private long count;
	
	public long getTotal() {
		return total;
	}
	public long getCount() {
		return count;
	}
	
	public synchronized void addToTotal(int number) {
		total += number;
		count++;
	}
	
	public double calculateAverage() {
		return (double) total / count;
	}
	
	

}
