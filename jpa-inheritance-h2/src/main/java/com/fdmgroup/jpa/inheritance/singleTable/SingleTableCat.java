package com.fdmgroup.jpa.inheritance.singleTable;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.NamedQuery;

@Entity
@NamedQuery(
	name = "SingleTableCat.findAllCats",
	query = "select c from SingleTableCat c")
@DiscriminatorValue("Cat")
public class SingleTableCat  extends SingleTableAnimal {
	private String favouriteLitter;

	public SingleTableCat() {}

	public SingleTableCat(String name, String breed, String colour, String favouriteLitter) {
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
		return "SingleTableCat [favouriteLitter=" + favouriteLitter + ", getName()=" + getName() + ", getBreed()="
				+ getBreed() + ", getColour()=" + getColour() + ", getAnimalId()=" + getAnimalId() + "]";
	}

	
	
}
