package com.fdmgroup.jpa.inheritance.joinedSuperclass;

import javax.persistence.Entity;

@Entity
public class JoinedDog extends JoinedAnimal{
	private String favouriteGame;

	public JoinedDog() {}

	public JoinedDog(String name, String breed, String colour, String favouriteGame) {
		super(name, breed, colour);
		this.favouriteGame = favouriteGame;
	}

	public String getFavouriteGame() {
		return favouriteGame;
	}

	public void setFavouriteGame(String favouriteGame) {
		this.favouriteGame = favouriteGame;
	}

	@Override
	public String toString() {
		return "JoinedDog [favouriteGame=" + favouriteGame + ", getName()=" + getName() + ", getBreed()=" + getBreed()
				+ ", getColour()=" + getColour() + ", getAnimalId()=" + getAnimalId() + "]";
	}

	
	
}
