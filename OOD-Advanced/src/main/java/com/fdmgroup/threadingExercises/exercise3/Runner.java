package com.fdmgroup.threadingExercises.exercise3;

public class Runner {

	public static void main(String[] args) {
		AverageCalculator averageCalculator = new AverageCalculator();
		// String fileName = "C:\\temp\\TestRecords.txt";
		// FileReaderThread fileReaderThread = new FileReaderThread(averageCalculator,
		// fileName);
		FileReaderThread fileReaderThread1 = new FileReaderThread(averageCalculator, "C:\\temp\\records1.txt");
		FileReaderThread fileReaderThread2 = new FileReaderThread(averageCalculator, "C:\\temp\\records2.txt");
		Thread currentTotalHead = new Thread(() -> {
			while (true) {
				System.out.println("Current total: " + averageCalculator.getTotal() + ", current count: "
						+ averageCalculator.getCount());
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					break;
				}
			}
		});

		System.out.println("Application has started");
		fileReaderThread1.start();
		fileReaderThread2.start();
		currentTotalHead.start();
		try {
			fileReaderThread1.join();
			fileReaderThread2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		currentTotalHead.interrupt();

		System.out.println("Final total: " + averageCalculator.getTotal() + ", final count: " + averageCalculator.getCount()
				+ ", average: " + averageCalculator.calculateAverage());

	}

}
