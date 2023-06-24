package com.fdmgroup.threadingExercises;

public class Runner {

	public static void main(String[] args) {
		ThreadManager threadManager = new ThreadManager();
		ThreadManagerChild threadManagerChild = new ThreadManagerChild();
		
		threadManager.createThreads(7);
		//threadManagerChild.createThreads(7);
		
		threadManager.runThreads();
		//threadManagerChild.runThreads();

	}

}
