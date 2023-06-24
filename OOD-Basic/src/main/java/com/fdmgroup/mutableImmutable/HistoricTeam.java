package com.fdmgroup.mutableImmutable;

import java.util.ArrayList;
import java.util.List;

public final class HistoricTeam {
	private final String name;
	private final List<Player> players; //non initialised
	
	public HistoricTeam(String name, List<Player> players) {
		super();
		this.name = name;
		this.players = new ArrayList<Player>();
		
		for(Player player : players) {
			this.players.add(new Player(player.getName(),player.getAge())); //Deep cloning
		}
	}

	public String getName() {
		return name;
	}

	public List<Player> getPlayers() {
		List<Player> clonedPlayers = new ArrayList<Player>();
		
		for(Player player : players) {
			clonedPlayers.add(new Player(player.getName(),player.getAge()));
		}
		
		return clonedPlayers;
	}
	
	
	
	

}
