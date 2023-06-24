package com.fdmgroup.threading.consumerProducer;

import java.util.LinkedList;
import java.util.Queue;

public class WorkQueue {

	private Queue<WorkItem> queue = new LinkedList<>();
	
	public synchronized void addWorkItem(WorkItem workItem) {
		if (queue.size() >= 10) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		queue.add(workItem);
	}
	
	public synchronized WorkItem getWorkItem() {
		if (queue.size() <= 5) {
			notify();
		}
		
		return queue.poll();
	}
	
	public int getQueueSize() {
		return queue.size();
	}
	
}
