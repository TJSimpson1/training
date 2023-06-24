package com.fdmgroup.jpa.inheritance.mappedSuperclass;

import javax.persistence.Entity;

@Entity
public class MappedSuperclassDog extends MappedSuperclassAnimal{
	private String favouriteGame;

	public MappedSuperclassDog() {}

	public MappedSuperclassDog(String name, String breed, String colour, String favouriteGame) {
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
		return "MappedSuperclassDog [favouriteGame=" + favouriteGame + ", getName()=" + getName() + ", getBreed()="
				+ getBreed() + ", getColour()=" + getColour() + ", getAnimalId()=" + getAnimalId() + "]";
	}
	
}
