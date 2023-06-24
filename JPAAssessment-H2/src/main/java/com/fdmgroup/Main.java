package com.fdmgroup;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.fdmgroup.model.Department;
import com.fdmgroup.model.Employee;
import com.fdmgroup.model.FullTimeEmployee;
import com.fdmgroup.model.PartTimeEmployee;

public class Main {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("JpaAssessment");
		EntityManager em = emf.createEntityManager();
		
		Department dept1 = new Department("Academy");
		Department dept2 = new Department("Sales");
		
		FullTimeEmployee fte1 = new FullTimeEmployee("John Doe", "Trainer", dept1, 100000);
		FullTimeEmployee fte2 = new FullTimeEmployee("Jane Doe", "Executive", dept2, 120000);
		
		PartTimeEmployee pte = new PartTimeEmployee("James Smith", "Trainer", dept1, 80);
		
		em.getTransaction().begin();
		em.persist(fte1);
		em.persist(fte2);
		em.persist(pte);
		em.getTransaction().commit();
		
		
		List<Employee> employeesInAcademy = em.createNamedQuery("Department.findByDeptName", Department.class)
				.setParameter("givenName", "Academy")
				.getResultList()
				.get(0)
				.getEmployees();
		
		employeesInAcademy.forEach(employee -> System.out.println(employee));
		
		em.close();
		emf.close();

	}

}
