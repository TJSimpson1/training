package com.fdmgroup.threading.reentrantLock;

public class ReentrantLockDemo1  {
	
	static AssetPrices assetPrices = new AssetPrices();
	
	public static void main(String[] args) {
		
		Thread updatePricesThread = new Thread(new Runnable() {

			@Override
			public void run() {
				System.out.println("Update prices thread: starting to update prices");
				assetPrices.getPricesLock().lock();
				
				try {
					assetPrices.setBitcoinPrice(35000);
					try {
						Thread.sleep(3000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					assetPrices.setGoldPrice(1950.89);
					System.out.println("Update prices thread: udpate prices complete");
				} finally {
					assetPrices.getPricesLock().unlock();
				}
			}

		});
		
		Thread viewPricesThread = new Thread(new Runnable() {

			@Override
			public void run() {
				
				assetPrices.getPricesLock().lock();
				try {
					System.out.println("View prices thread: displaying current prices");
					System.out.println("Bitcoin: " + assetPrices.getBitcoinPrice());
					System.out.println("Gold: " + assetPrices.getGoldPrice());
				} finally {
					assetPrices.getPricesLock().unlock();
				}
				
			}
			
		});
		
		updatePricesThread.start();
		try {
			Thread.sleep(2);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		viewPricesThread.start();
		
	}

}
