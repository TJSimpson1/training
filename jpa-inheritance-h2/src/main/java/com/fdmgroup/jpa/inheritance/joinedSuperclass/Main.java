package com.fdmgroup.jpa.inheritance.joinedSuperclass;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpainheritance");
		EntityManager em = emf.createEntityManager();
		
		System.out.println("==============================================");
		System.out.println("Persisting Joined Entities to the DB");
		System.out.println("==============================================");
		
		//Create some cats and dogs and then persist them
		JoinedDog dog1 = new JoinedDog("Peanut", "Schnauzer", "Salt & Pepper", "Fetch");
		JoinedCat cat1 = new JoinedCat("Luna", "British Shorthair", "Black", "Clay");
		JoinedCat cat2 = new JoinedCat("Freya", "Siberian", "Blue", "Walnut");
		
		//Persisting them
		em.getTransaction().begin();
			em.persist(dog1);
			em.persist(cat1);
			em.persist(cat2);
		em.getTransaction().commit();
		
		System.out.println("==============================================");
		System.out.println("Query for fetching all animals");
		System.out.println("==============================================");
				
		List<JoinedAnimal> allPersistedAnimals = em.createNamedQuery("JoinedAnimal.findAllAnimals", JoinedAnimal.class)
				.getResultList();
				
		System.out.println("==============================================");
		System.out.println("Printing all Animals");
		System.out.println("==============================================");
					
		allPersistedAnimals.forEach(animal -> System.out.println(animal));
				
		System.out.println("==============================================");
		System.out.println("Query for fetching all cats");
		System.out.println("==============================================");
				
		List<JoinedCat> allPersistedCats = em.createNamedQuery("JoinedCat.findAllCats", JoinedCat.class)
				.getResultList();
				
		System.out.println("==============================================");
		System.out.println("Printing all Cats");
		System.out.println("==============================================");
				
		allPersistedCats.forEach(cat -> System.out.println(cat));
		
		em.close();
		emf.close();
	}

}
