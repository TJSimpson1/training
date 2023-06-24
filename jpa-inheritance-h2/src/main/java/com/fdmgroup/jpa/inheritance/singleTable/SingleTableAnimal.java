package com.fdmgroup.jpa.inheritance.singleTable;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.MappedSuperclass;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;

@Entity
@NamedQuery(
	name = "SingleTableAnimal.findAllAnimals",
	query = "select a from SingleTableAnimal a")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "SPECIES")
public abstract class SingleTableAnimal {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "singletableanimalgen")
	@SequenceGenerator(name = "singletableanimalgen", sequenceName = "singletableanimalseq", allocationSize = 1)
	private int animalId;
	private String name;
	private String breed;
	private String colour;
	
	public SingleTableAnimal() {}
	
	public SingleTableAnimal(String name, String breed, String colour) {
		super();
		this.name = name;
		this.breed = breed;
		this.colour = colour;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBreed() {
		return breed;
	}

	public void setBreed(String breed) {
		this.breed = breed;
	}

	public String getColour() {
		return colour;
	}

	public void setColour(String colour) {
		this.colour = colour;
	}

	public int getAnimalId() {
		return animalId;
	}

	@Override
	public String toString() {
		return "SingleTableAnimal [animalId=" + animalId + ", name=" + name + ", breed=" + breed + ", colour=" + colour
				+ "]";
	}


	
	
	
}
