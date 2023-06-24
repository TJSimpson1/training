package com.fdmgroup.designPatterns.factory;

public class PredictableOpponentFactory implements OpponentFactory {

	private int count;
	
	@Override
	public Opponent createOpponent() {
		count ++;
		
		if (count %3 == 0) {
			return new Alien();
		}
		
		if (count %3 == 1) {
			return new Zombie();
		}
		
		return new Cyborg();
	}

}
