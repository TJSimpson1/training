package com.fdmgroup.jpa.inheritance.tablePerConcrete;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpainheritance");
		EntityManager em = emf.createEntityManager();
		
		System.out.println("==============================================");
		System.out.println("Persisting Table per concrete Entities to the DB");
		System.out.println("==============================================");
		
		//Create some cats and dogs and then persist them
		TablePerConcreteDog dog1 = new TablePerConcreteDog("Peanut", "Schnauzer", "Salt & Pepper", "Fetch");
		TablePerConcreteCat cat1 = new TablePerConcreteCat("Luna", "British Shorthair", "Black", "Clay");
		TablePerConcreteCat cat2 = new TablePerConcreteCat("Freya", "Siberian", "Blue", "Walnut");
		
		//Persisting them
		em.getTransaction().begin();
			em.persist(dog1);
			em.persist(cat1);
			em.persist(cat2);
		em.getTransaction().commit();
		
		System.out.println("==============================================");
		System.out.println("Query for fetching all animals");
		System.out.println("==============================================");
				
		List<TablePerConcreteAnimal> allPersistedAnimals = em.createNamedQuery("TablePerConcreteAnimal.findAllAnimals", TablePerConcreteAnimal.class)
				.getResultList();
				
		System.out.println("==============================================");
		System.out.println("Printing all Animals");
		System.out.println("==============================================");
					
		allPersistedAnimals.forEach(animal -> System.out.println(animal));
				
		System.out.println("==============================================");
		System.out.println("Query for fetching all cats");
		System.out.println("==============================================");
				
		List<TablePerConcreteCat> allPersistedCats = em.createNamedQuery("TablePerConcreteCat.findAllCats", TablePerConcreteCat.class)
				.getResultList();
				
		System.out.println("==============================================");
		System.out.println("Printing all Cats");
		System.out.println("==============================================");
				
		allPersistedCats.forEach(cat -> System.out.println(cat));
		
		em.close();
		emf.close();
	}

}
