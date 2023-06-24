package com.fdmgroup.threadingExercises;

import java.util.ArrayList;
import java.util.List;

public class ThreadManager {
	protected List<Thread> threads = new ArrayList<>();
	
	public void createThreads(int number) {
		for(int index = 1; index <= number; index++) {
			MyRunnable runnable = new MyRunnable();
			Thread thread = new Thread(runnable);
			String string = "thread" + index;
			thread.setName(string);
			threads.add(thread);
		}
	}
	
	public void runThreads() {
		for(Thread thread : threads) {
			thread.start();
		}
	}

}
