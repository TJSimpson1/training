package com.fdmgroup.jpa.inheritance.mappedSuperclass;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.SequenceGenerator;

//Cannot query from the parent when this strategy is used.
@MappedSuperclass
public abstract class MappedSuperclassAnimal {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "animalgen")
	@SequenceGenerator(name = "animalgen", sequenceName = "animalseq", allocationSize = 1)
	private int animalId;
	private String name;
	private String breed;
	private String colour;
	
	public MappedSuperclassAnimal() {}
	
	public MappedSuperclassAnimal(String name, String breed, String colour) {
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
		return "MappedSuperclassAnimal [animalId=" + animalId + ", name=" + name + ", breed=" + breed + ", colour="
				+ colour + "]";
	}

	
	
	
	
}
