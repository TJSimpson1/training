package com.fdmgroup.mutableImmutable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Runner {

	public static void main(String[] args) {
		Player player1 = new Player("Bobby Charlton", 20);
		Player player2 = new Player("Roger Byrne", 28);
		Player player3 = new Player("Duncan Edwards", 21);
		Player player4 = new Player("Eddie Colman", 21);
		
		List<Player> players = new ArrayList<Player>(Arrays.asList(player1, player2, player3));
		
		HistoricTeam historicTeam = new HistoricTeam("Manchester United", players);
		
		players.add(player4);
		player1.setAge(50);
		player2.setAge(58);
		player3.setAge(51);
		
		for(Player eachPlayer : historicTeam.getPlayers()) {
			System.out.println(eachPlayer.getName() + ": " + eachPlayer.getAge());
		}

	}

}
