package com.fdmgroup.designPatterns.factory;

public class Runner {

	public static void main(String[] args) {
		RandomOpponentFactory randomOpponentFactory = new RandomOpponentFactory();
		PredictableOpponentFactory predictableOpponentFactory = new PredictableOpponentFactory();
		
		Game game = new Game();
		
		game.setOpponentFactory(randomOpponentFactory);
		
		game.playNextOpponent();
		game.playNextOpponent();
		game.playNextOpponent();
		game.playNextOpponent();
		game.playNextOpponent();
		game.playNextOpponent();
		game.playNextOpponent();
		game.playNextOpponent();
		game.playNextOpponent();

	}

}
