package com.fdmgroup.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

/*
 * 1. Start the factory
 * 2. Start the entity manager
 * 3. Do whatever you need to do with that entity manager
 * 4. Close the entity manager connection
 * 	---REPEAT 2-4 AS REQUIRED---
 * 5. Close the factory	
 */
public class Main {

	public static void main(String[] args) {
		//Step 1: Create an entity manager factory
		EntityManagerFactory emf = 
				Persistence.createEntityManagerFactory("jpabasic");
				
		//Step 2: Create an entity manager
		EntityManager em = emf.createEntityManager();
				
		EntityTransaction txn = 
				em.getTransaction();	
				
		Dog dog1 = new Dog("Max", "Golden Retriever", false);
		Dog dog2 = new Dog("Apolo", "French Bulldog", true);
		Dog dog3 = new Dog("Cinnamon", "Chihuahua", true);
		
		txn.begin();
		
		em.persist(dog1); //Pure save
//		em.persist(dog2);
		em.persist(dog3);
//		em.merge(dog1);
		
		txn.commit();
		
		txn.begin();
		//Pure update using a managed instance
		dog1.setNeutered(true);
		txn.commit();
		
		txn.begin();
		//Save OR update
		dog2 = em.merge(dog2);
		txn.commit();
		
		dog2.setNeutered(false);
		
		txn.begin();
		em.merge(dog2);
		txn.commit();
		
//		txn.begin();
//		em.remove(dog1);
//		em.remove(dog2);
//		txn.commit();
		
		/*
		 * Using built-in find method from entity manager	
		 * 
		 * Takes:
		 * 		1. Class of object we're looking for
		 * 		2. ID or primary key
		 */
//		Dog persistedDog1 = em.find(Dog.class, 1L);
//		System.out.println(persistedDog1);
		
		
		//NEVER FORGET TO CLOSE THE MANAGER
		em.close();
		
		
		EntityManager emFind =
				emf.createEntityManager();
		
		/*
		 * Using built-in find method from entity manager	
		 * 
		 * Takes:
		 * 		1. Class of object we're looking for
		 * 		2. ID or primary key
		 */
		Dog persistedDog1 = emFind.find(Dog.class, 1L);
		System.out.println(persistedDog1);
		
		emFind.close();
		
		
		
		
		
		EntityManager emFindAll = 
				emf.createEntityManager();
		
		String jpql = "SELECT d FROM Dog d";
		TypedQuery<Dog> query = emFindAll.createQuery(jpql, Dog.class);
		List<Dog> results = query.getResultList();
		System.out.println(results);
		System.out.println(results.get(0).isNeutered());
//		System.out.println(((Dog) results.get(0)).isNeutered()); //BAD - can't know that the object will be a dog object
		
//		if(results.get(0) instanceof Dog) {
//			Dog foundDog = (Dog) results.get(0);
//			System.out.println(foundDog.isNeutered());
//		}
		
		emFindAll.close();
		
		
		
		EntityManager emFindAllBreeds =
				emf.createEntityManager();
		
		String jpqlBreeds = "SELECT d.breed FROM Dog d";
		TypedQuery<String> queryBreeds = emFindAllBreeds.createQuery(jpqlBreeds, String.class);
		List<String> resultsBreeds = queryBreeds.getResultList();
		System.out.println(resultsBreeds);
		
		emFindAllBreeds.close();
		
		
		EntityManager emFindAllDogsNotNeutered =
				emf.createEntityManager();
		
		String jpqlNotNeutered = "SELECT d FROM Dog d WHERE d.isNeutered = false";
		TypedQuery<Dog> queryNotNeutered = emFindAllDogsNotNeutered.createQuery(jpqlNotNeutered, Dog.class);
		List<Dog> notNeuteredDogs = queryNotNeutered.getResultList();
		System.out.println(notNeuteredDogs);
		
		emFindAllDogsNotNeutered.close();
		
		
		
		
		EntityManager emFindAllNotNeuteredWithUserInput = 
				emf.createEntityManager();
		
		String jpqlNotNeuteredWithInput = "SELECT d FROM Dog d WHERE d.isNeutered = :someGivenValue";
		TypedQuery<Dog> queryNotNeuteredWithInput = emFindAllNotNeuteredWithUserInput.createQuery(jpqlNotNeuteredWithInput, Dog.class);
		queryNotNeuteredWithInput.setParameter("someGivenValue", true);
		List<Dog> notNeuteredDogsWithInput = queryNotNeuteredWithInput.getResultList();
		System.out.println(notNeuteredDogsWithInput);
		
		emFindAllNotNeuteredWithUserInput.close();
		
		
		
		
		EntityManager emNamedQuery = emf.createEntityManager();
		
		TypedQuery<Dog> namedQuery = emNamedQuery.createNamedQuery("findAllDogs", Dog.class);
		List<Dog> namedResults = namedQuery.getResultList();
		System.out.println(namedResults);
		
		emNamedQuery.close();
		
		
		//NEVER FORGET TO CLOSE THE FACTORY!
		emf.close();
		
	}

}
