package com.fdmgroup.threading.reentrantLock;

import java.util.concurrent.locks.ReentrantLock;

public class AssetPrices {
	
	private ReentrantLock pricesLock = new ReentrantLock();
	
	private double goldPrice;
	private double bitcoinPrice;
	
	public ReentrantLock getPricesLock() {
		return pricesLock;
	}
	
	public double getGoldPrice() {
		return goldPrice;
	}
	public void setGoldPrice(double goldPrice) {
		this.goldPrice = goldPrice;
	}
	public double getBitcoinPrice() {
		return bitcoinPrice;
	}
	public void setBitcoinPrice(double bitcoinPrice) {
		this.bitcoinPrice = bitcoinPrice;
	}
	
}
