package com.fdmgroup.threading.consumerProducer;

public class Runner {

	public static void main(String[] args) {
		WorkQueue workQueue = new WorkQueue();
		
		
		Thread producerThread = new Thread(() -> {
			int count = 1;
			while(true) {
				System.out.println("producer adding item "+count+" to queue");
				System.out.println("queue contains "+workQueue.getQueueSize()+" items");
				workQueue.addWorkItem(new WorkItem(count));
				count ++;
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});
		
		Thread consumerThread = new Thread(() -> {
			while(true) {
				WorkItem currentItem = workQueue.getWorkItem();
				System.out.println("consumer processing item "+currentItem.getItemId());
				try {
					Thread.sleep(1500);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});
		
		producerThread.start();
		
		try {
			Thread.sleep(15);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		consumerThread.start();

	}

}
