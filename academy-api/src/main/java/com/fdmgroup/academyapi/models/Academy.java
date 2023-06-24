package com.fdmgroup.academyapi.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity(name="academies")
public class Academy {

	@Id
	@Column(name="academy_id")
	@SequenceGenerator(name = "ACADEMY_ID_GEN", sequenceName = "academy_id_seq", initialValue = 5, allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ACADEMY_ID_GEN")
	private int id;
	@Column(unique = true)
	private String name;
	private String address;
	
	public int getId() {
		return id;
	}
	public void setId(int academyId) {
		this.id = academyId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
}
