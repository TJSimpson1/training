package com.fdmgroup.jpa.inheritance.singleTable;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("Dog")
public class SingleTableDog extends SingleTableAnimal{
	private String favouriteGame;

	public SingleTableDog() {}

	public SingleTableDog(String name, String breed, String colour, String favouriteGame) {
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
		return "SingleTableDog [favouriteGame=" + favouriteGame + ", getName()=" + getName() + ", getBreed()="
				+ getBreed() + ", getColour()=" + getColour() + ", getAnimalId()=" + getAnimalId() + "]";
	}

	
	
}
