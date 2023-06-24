package com.fdmgroup.exercises;

import java.util.ArrayList;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;

@Entity
public class Module {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "module_gen")
	@SequenceGenerator(name = "module_gen", sequenceName = "module_seq", allocationSize=1)
	@Column(name = "MODULE_ID")
	private int id;
	@Column(name = "MODULE_NAME", unique = true, nullable = false)
	private String name;
	@ManyToMany(mappedBy = "modules")
	private List<Stream> streams = new ArrayList<>();
	
	Module() {}
	
	
	
	public Module(String name) {
		super();
		this.name = name;
	}



	public void addStream(Stream stream) {
		streams.add(stream);
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<Stream> getStreams() {
		return streams;
	}
	public void setStreams(List<Stream> streams) {
		this.streams = streams;
	}



	@Override
	public String toString() {
		return "Module [id=" + id + ", name=" + name + "]";
	}



	
	
	
	
	
}
