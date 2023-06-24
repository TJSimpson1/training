package com.fdmgroup.jpa.inheritance.joinedSuperclass;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;

@Entity
@NamedQuery(
		name = "JoinedAnimal.findAllAnimals",
		query = "select a from JoinedAnimal a")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class JoinedAnimal {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "joinedanimalgen")
	@SequenceGenerator(name = "joinedanimalgen", sequenceName = "joinedanimalseq", allocationSize = 1)
	private int animalId;
	private String name;
	private String breed;
	private String colour;
	
	public JoinedAnimal() {}
	
	public JoinedAnimal(String name, String breed, String colour) {
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
		return "JoinedAnimal [animalId=" + animalId + ", name=" + name + ", breed=" + breed + ", colour=" + colour
				+ "]";
	}

	
	
	
	
}
