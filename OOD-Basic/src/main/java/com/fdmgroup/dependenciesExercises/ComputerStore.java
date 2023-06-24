package com.fdmgroup.dependenciesExercises;

import java.util.ArrayList;
import java.util.List;

public class ComputerStore {
	private String name;
	private ArrayList<Computer> computers = new ArrayList<Computer>();
	
	public ComputerStore(String name) {
		super();
		this.name = name;
	}
	
	public void addComputer(Computer computer) {
		computers.add(computer);
	}
	
	public ArrayList<Computer> getAllComputers() {
		return computers;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
	

}
