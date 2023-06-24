package com.fdmgroup.jpa.inheritance.mappedSuperclass;

import javax.persistence.Entity;
import javax.persistence.NamedQuery;

@Entity
@NamedQuery(name = "MappedSuperclassCat.findAll",
	query = "select c from MappedSuperclassCat c")
public class MappedSuperclassCat  extends MappedSuperclassAnimal {
	private String favouriteLitter;

	public MappedSuperclassCat() {}

	public MappedSuperclassCat(String name, String breed, String colour, String favouriteLitter) {
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
		return "MappedSuperclassCat [favouriteLitter=" + favouriteLitter + ", getName()=" + getName() + ", getBreed()="
				+ getBreed() + ", getColour()=" + getColour() + ", getAnimalId()=" + getAnimalId() + "]";
	}
	
}
