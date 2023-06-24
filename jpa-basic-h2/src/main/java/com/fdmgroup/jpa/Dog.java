package com.fdmgroup.jpa;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 * 1. @Entity
 * 2. @Id
 * 3. non-priv, non-args constructor
 */

//This entity will tell JPA that this class is going to be an entity
//so it will generate a SQL table based in our mapping
@Entity
@Table(name="DOG_TABLE")
@NamedQuery(name = "findAllDogs", query = "SELECT d FROM Dog d")
public class Dog {
	//ID: This will be the primary key of the table
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "dog_gen")
	@SequenceGenerator(name = "dog_gen", sequenceName = "dog_seq", allocationSize = 1)
	@Column(name="DOG_ID")
	private long id;
	@Column(name="DOG_NAME", nullable=false, updatable=false)
	private String name;
	@Column(name="DOG_BREED", nullable=false, updatable=false)
	private String breed;
	@Column(name="IS_NEUTERED", nullable=false)
	private boolean isNeutered;
	@Transient
	private boolean isSleeping;
	
	//Non-private non-args constructor
	public Dog() {}
	
	public Dog(String name, String breed, boolean isNeutered) {
		super();
		this.name = name;
		this.breed = breed;
		this.isNeutered = isNeutered;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
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

	public boolean isNeutered() {
		return isNeutered;
	}

	public void setNeutered(boolean isNeutered) {
		this.isNeutered = isNeutered;
	}

	public boolean isSleeping() {
		return isSleeping;
	}

	public void setSleeping(boolean isSleeping) {
		this.isSleeping = isSleeping;
	}

	@Override
	public String toString() {
		return "Dog [id=" + id + ", name=" + name + ", breed=" + breed + ", isNeutered=" + isNeutered + ", isSleeping="
				+ isSleeping + "]";
	}
	
	
	
	
	
}
