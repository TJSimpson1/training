package com.fdmgroup.jpa;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Test {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpainheritance");

		System.out.println("Connected to h2 database");
				
		emf.close();
	}

}
