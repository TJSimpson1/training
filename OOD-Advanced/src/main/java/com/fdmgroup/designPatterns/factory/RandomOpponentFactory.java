package com.fdmgroup.designPatterns.factory;

public class RandomOpponentFactory implements OpponentFactory {

	@Override
	public Opponent createOpponent() {
		double randomNumber = Math.random();
		
		if (randomNumber < 0.333) {
			return new Alien();
		}
		
		if (randomNumber < 0.666) {
			return new Zombie();
		}
		
		return new Cyborg();
	}

}
