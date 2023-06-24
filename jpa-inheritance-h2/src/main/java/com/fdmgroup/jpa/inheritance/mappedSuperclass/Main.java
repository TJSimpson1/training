package com.fdmgroup.jpa.inheritance.mappedSuperclass;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpainheritance");
		EntityManager em = emf.createEntityManager();
		
		System.out.println("==============================================");
		System.out.println("Persisting MappedSuperClass Entities to the DB");
		System.out.println("==============================================");
		
		//Create some cats and dogs and then persist them
		MappedSuperclassDog dog1 = new MappedSuperclassDog("Peanut", "Schnauzer", "Salt & Pepper", "Fetch");
		MappedSuperclassCat cat1 = new MappedSuperclassCat("Luna", "British Shorthair", "Black", "Clay");
		MappedSuperclassCat cat2 = new MappedSuperclassCat("Freya", "Siberian", "Blue", "Walnut");
		
		//Persisting them
		em.getTransaction().begin();
			em.persist(dog1);
			em.persist(cat1);
			em.persist(cat2);
		em.getTransaction().commit();
		
		System.out.println("==============================================");
		System.out.println("Query for fetching all cats");
		System.out.println("==============================================");
				
		List<MappedSuperclassCat> allPersistedCats = em.createNamedQuery("MappedSuperclassCat.findAll", MappedSuperclassCat.class)
				.getResultList();
				
		System.out.println("==============================================");
		System.out.println("Printing all Cats");
		System.out.println("==============================================");
				
		allPersistedCats.forEach(cat -> System.out.println(cat));
		
		em.close();
		emf.close();
	}

}
