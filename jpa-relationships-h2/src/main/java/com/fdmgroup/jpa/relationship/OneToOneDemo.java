package com.fdmgroup.jpa.relationship;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class OneToOneDemo {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jparelationship");
		EntityManager em = emf.createEntityManager();
		
		Passport passport1 = new Passport(1, "PASSNO1");
		Person person1 = new Person(1, "Travis", "Simpson", "GBR", passport1);
		
		Passport passport2 = new Passport(2, "PASSNO2");
		Person person2 = new Person(2, "John", "Doe", "AUS", passport2);
		
		Passport passport3 = new Passport(3, "PASSNO3");
		Person person3 = new Person(3, "Jane", "Doe", "DEU", passport3);
		
		
		em.getTransaction().begin();
		em.persist(person1);
		em.persist(person2);
		em.persist(person3);
		em.getTransaction().commit();
		
		System.out.println("Query to find person by nationality with user input");
		
		Person gbrPerson = em.createQuery("SELECT p FROM Person p WHERE p.nationality = :givenNationality", Person.class)
			.setParameter("givenNationality",  "GBR")
			.getResultList()
			.get(0);
		
		System.out.println(gbrPerson);
		
		System.out.println("Using named query to find passport by last name");
		
		List<Passport> passportsFoundByLastName = em.createNamedQuery("Person.findPassportByLastName", Passport.class)
				.setParameter("givenLastName", "Doe")
				.getResultList();
		
		passportsFoundByLastName.forEach(passport -> System.out.println(passport));
		
		Passport passport4 = new Passport(4, "PASSNO4");
//		passport4.setPerson(person3);
		person3.setPassport(passport4);
		
		em.getTransaction().begin();
//		passport4 = em.merge(passport4);
		person3 = em.merge(person3);
		em.getTransaction().commit();
		
		System.out.println("Query to find person based on passport number");
		
		Person personFromPassportNo = em.createQuery("SELECT p.person FROM Passport p WHERE p.passportNumber = :givenPassNo", Person.class)
				.setParameter("givenPassNo", "PASSNO1")
				.getResultList()
				.get(0);
		
		System.out.println(personFromPassportNo);
		
		em.close();
		emf.close();

	}

}
