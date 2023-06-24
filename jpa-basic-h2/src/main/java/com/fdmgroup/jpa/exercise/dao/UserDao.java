package com.fdmgroup.jpa.exercise.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import com.fdmgroup.jpa.exercise.model.User;

public class UserDao {
	private EntityManagerFactory emf;

	public UserDao(EntityManagerFactory emf) {
		super();
		this.emf = emf;
	}
	
	public void persist(User user) {
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		em.persist(user);
		em.getTransaction().commit();
		
		em.close();
	}
	
	public List<User> findAll(){
		EntityManager em = emf.createEntityManager();
//		String jpql = "SELECT u FROM User u";
//		TypedQuery<User> query = em.createQuery(jpql, User.class);
//		List<User> results = query.getResultList();
		List<User> results = em.createQuery("SELECT u FROM User u", User.class)
				.getResultList();
		em.close();
		return results; //ALWAYS return AFTER closing the manager
	}
	
	public User findByUsername(String username) {
		EntityManager em = emf.createEntityManager();
//		String jpql = "SELECT u FROM User u WHERE u.username = :someUsername";
//		TypedQuery<User> query = em.createQuery(jpql, User.class);
//		query.setParameter("someUsername", username);
//		List<User> results = query.getResultList();
		User result = em.createQuery("SELECT u FROM User u WHERE u.username = :someUsername", User.class)
				.setParameter("someUsername", username)
				.getResultList()
				.get(0);
		em.close();
		return result;
	}
	
	public void updateUser(User user) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.merge(user);
		em.getTransaction().commit();
		em.close();
	}
	
	public void deleteById(int id) {
		EntityManager em = emf.createEntityManager();
//		String jpql = "DELETE FROM User u WHERE u.id = :someId";
//		Query query = em.createQuery(jpql);
//		query.setParameter("someId", id);
		Query query = em.createQuery("DELETE FROM User u WHERE u.id = :someId")
				.setParameter("someId", id);
		em.getTransaction().begin();
		query.executeUpdate();
		em.getTransaction().commit();
		em.close();
	}
}
