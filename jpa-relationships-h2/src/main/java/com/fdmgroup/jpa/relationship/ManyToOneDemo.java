package com.fdmgroup.jpa.relationship;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ManyToOneDemo {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jparelationship");
		EntityManager em = emf.createEntityManager();
		
		Trainer trainer1 = new Trainer("Edgar", "Afonso", "Software Development");
		Trainer trainer2 = new Trainer("Nick", "Lawton", "Software Development");
		Trainer trainer3 = new Trainer("Adrian", "Obrien", "Software Development");
		Trainer trainer4 = new Trainer("John", "Doe", "Software Development");
		
		Academy academy1 = new Academy("London");
		Academy academy2 = new Academy("Glasgow");
		
//		academy1.getTrainers().add(trainer1);
//		academy1.getTrainers().add(trainer2);
//		academy1.getTrainers().add(trainer3);
//		academy2.getTrainers().add(trainer4);
		
		academy1.addTrainer(trainer1);
		academy1.addTrainer(trainer2);
		academy1.addTrainer(trainer3);
		academy2.addTrainer(trainer4);
		
		em.getTransaction().begin();
//		em.persist(academy1);
		em.persist(trainer1);
		em.persist(trainer2);
		em.persist(trainer3);
		em.getTransaction().commit();
		
		List<Trainer> persistedTrainersFromLondon = em.createNamedQuery("Trainer.findTrainerByAcademyLocation", Trainer.class)
				.setParameter("givenLocation", "London")
				.getResultList();
		
		persistedTrainersFromLondon.forEach(trainer -> System.out.println(trainer));
		
		em.close();
		emf.close();
	}

}
