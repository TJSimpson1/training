package com.fdmgroup.jpa.inheritance.tablePerConcrete;

import javax.persistence.Entity;
import javax.persistence.NamedQuery;

@Entity
@NamedQuery(
		name = "TablePerConcreteCat.findAllCats",
		query = "select c from TablePerConcreteCat c")
public class TablePerConcreteCat  extends TablePerConcreteAnimal {
	private String favouriteLitter;

	public TablePerConcreteCat() {}

	public TablePerConcreteCat(String name, String breed, String colour, String favouriteLitter) {
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
		return "TablePerConcreteCat [favouriteLitter=" + favouriteLitter + ", getName()=" + getName() + ", getBreed()="
				+ getBreed() + ", getColour()=" + getColour() + ", getAnimalId()=" + getAnimalId() + "]";
	}

	
	
}
