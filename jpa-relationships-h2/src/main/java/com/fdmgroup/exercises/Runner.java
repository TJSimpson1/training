package com.fdmgroup.exercises;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Runner {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jparelationship");
		EntityManager em = emf.createEntityManager();
		
		Module module1 = new Module("SQL");
		Module module2 = new Module("OOD");

		Stream stream1 = new Stream("Software Development");
		Stream stream2 = new Stream("BABI");
		
		Trainee trainee1 = new Trainee("John", "Doe", stream1);
		Trainee trainee2 = new Trainee("James", "Smith", stream2);
		Trainee trainee3 = new Trainee("Jane", "Doe", stream1);
		
		stream1.addModule(module1);
		stream1.addModule(module2);
		stream2.addModule(module1);
		
		em.getTransaction().begin();
		em.persist(trainee1);
		em.persist(trainee2);
		em.persist(trainee3);
		em.getTransaction().commit();
		
		System.out.println("\n\n===========================================================================");
		System.out.println("===========================================================================");
		System.out.println("======================findModulesRelatedToStream===========================");
		System.out.println("===========================================================================");
		System.out.println("===========================================================================");
		
		Stream streamByName = em.createNamedQuery("Stream.findByStreamName", Stream.class)
				.setParameter("givenName", "BABI")
				.getResultList()
				.get(0);
//		Stream streamByName2 = em.createQuery("SELECT s FROM Stream s WHERE s.name = :givenName", Stream.class)
//				.setParameter("givenName", "BABI")
//				.getResultList()
//				.get(0);
		streamByName.getModules().forEach(module -> System.out.println(module));
		
		System.out.println("\n\n===========================================================================");
		System.out.println("===========================================================================");
		System.out.println("=======================findTraineesByStream================================");
		System.out.println("===========================================================================");
		System.out.println("===========================================================================");
		
		List<Trainee> traineesByStream = em.createNamedQuery("Trainee.findByStream", Trainee.class)
				.setParameter("givenStream", stream1)
				.getResultList();
		traineesByStream.forEach(trainee -> System.out.println(trainee));
		
		em.close();
		emf.close();
		
		

	}

}
