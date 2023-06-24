package com.fdmgroup.threading;

public class DualCounter {
	private int count1;
	private int count2;
	
	private Object count1Lock = new Object();
	private Object count2Lock = new Object();
	
	public int getCount1() {
		synchronized(count1Lock) {
			return count1;
		}
	}
	
	public int getCount2() {
		synchronized(count2Lock) {
			return count2;
		}
	}
	
	public void incrementCount1() {
		synchronized(count1Lock) {
			count1++;
		}
	}
	
	public void incrementCount2() {
		synchronized(count2Lock) {
			count2++;
		}
	}
	
	public void decrementCount1() {
		synchronized(count1Lock) {
			count1--;
		}
	}
	
	public void decrementCount2() {
		synchronized(count2Lock) {
			count2--;
		}
	}
}
