package com.fdmgroup.designPatterns.factory;

public class Game {

	private Opponent opponent;
	
	private OpponentFactory opponentFactory;

	public void setOpponentFactory(OpponentFactory opponentFactory) {
		this.opponentFactory = opponentFactory;
	}

	public void playNextOpponent() {
		opponent = opponentFactory.createOpponent();
		opponent.play();
	}
	
}
