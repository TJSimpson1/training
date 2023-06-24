package com.fdmgroup.designPatterns.factory;

public class Zombie implements Opponent {

	@Override
	public void play() {
		System.out.println("zombie is playing");
	}

}
