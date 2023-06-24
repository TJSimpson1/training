package com.fdmgroup.jpa.inheritance.joinedSuperclass;

import javax.persistence.Entity;
import javax.persistence.NamedQuery;

@Entity
@NamedQuery(
		name = "JoinedCat.findAllCats",
		query = "select c from JoinedCat c")
public class JoinedCat  extends JoinedAnimal {
	private String favouriteLitter;

	public JoinedCat() {}

	public JoinedCat(String name, String breed, String colour, String favouriteLitter) {
		super(name, breed, colour);
		this.favouriteLitter = favouriteLitter;
	}

	public String getFavouriteLitter() {
		return favouriteLitter;
	}

	public void setFavouriteLitter(String favouriteLitter) {
		this.favouriteLitter = favouriteLitter;
	}

	@Override
	public String toString() {
		return "JoinedCat [favouriteLitter=" + favouriteLitter + ", getFavouriteLitter()=" + getFavouriteLitter()
				+ ", getName()=" + getName() + ", getBreed()=" + getBreed() + ", getColour()=" + getColour()
				+ ", getAnimalId()=" + getAnimalId() + "]";
	}

	
	
}
