package com.fdmgroup.threadingExercises;

public class ThreadManagerChild extends ThreadManager {
	
	@Override
	public void createThreads(int number) {
		for(int index = 1; index <= number; index++) {
			String string = "thread" + index;
			Thread thread = new Thread(() -> {
				System.out.println(Thread.currentThread().getName() + " is running");
			});
			thread.setName(string);
			threads.add(thread);
		}
	}

}
