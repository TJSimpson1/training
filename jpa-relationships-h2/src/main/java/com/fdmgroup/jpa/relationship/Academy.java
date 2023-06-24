package com.fdmgroup.jpa.relationship;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

@Entity
public class Academy {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "academy_gen")
	@SequenceGenerator(name = "academy_gen", sequenceName = "academy_seq", allocationSize=1)
	private int id;
	private String location;
	
	@OneToMany(mappedBy = "academy")
//	@OneToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
//	@JoinColumn(name = "FK_ACADEMY_ID")
	private List<Trainer> trainers = new ArrayList<>();
	
	Academy() {}
	
	public Academy(String location) {
		super();
		this.location = location;
	}
	
	public void addTrainer(Trainer trainer) {
		this.trainers.add(trainer);
		trainer.setAcademy(this);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public List<Trainer> getTrainers() {
		return trainers;
	}

	public void setTrainers(List<Trainer> trainers) {
		this.trainers = trainers;
	}

	@Override
	public String toString() {
		return "Academy [id=" + id + ", location=" + location + ", trainers=" + trainers + "]";
	}
	
}
