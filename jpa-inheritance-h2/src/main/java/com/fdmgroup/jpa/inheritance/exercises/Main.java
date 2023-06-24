package com.fdmgroup.jpa.inheritance.exercises;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpainheritance");
		EntityManager em = emf.createEntityManager();
		
		Person person1 = new Person("John", "Smith", "123 Fake Street");
		
		Company company1 = new Company("Google", 123456789L, "456 Real Street");
		
		SavingsAccount savingsAccount1 = new SavingsAccount(1234.50, person1);
		SavingsAccount savingsAccount2 = new SavingsAccount(10500, company1);
		CheckingAccount checkingAccount1 = new CheckingAccount(-525.25, person1);
		CheckingAccount checkingAccount2 = new CheckingAccount(-250.0, company1);
		
		em.getTransaction().begin();
		em.persist(savingsAccount1);
		em.persist(checkingAccount2);
		em.persist(checkingAccount1);
		em.persist(savingsAccount2);
		em.getTransaction().commit();
		
		
		System.out.println("\n\n===========================================================================");
		System.out.println("===========================================================================");
		System.out.println("=======================findAllBankAccounts=================================");
		System.out.println("===========================================================================");
		System.out.println("===========================================================================");
		
		List<BankAccount> bankAccounts = em.createNamedQuery("BankAccount.findAll", BankAccount.class)
				.getResultList();
		bankAccounts.forEach(account -> System.out.println(account));
		
		System.out.println("\n\n===========================================================================");
		System.out.println("===========================================================================");
		System.out.println("=======================findCompanyByName===================================");
		System.out.println("===========================================================================");
		System.out.println("===========================================================================");
		
		Company companyByName = em.createNamedQuery("Company.findByName", Company.class)
				.setParameter("givenName", "Google")
				.getResultList()
				.get(0);
		System.out.println(companyByName);
		
		System.out.println("\n\n===========================================================================");
		System.out.println("===========================================================================");
		System.out.println("=======================deposit100IntoSavings===============================");
		System.out.println("===========================================================================");
		System.out.println("===========================================================================");
		
		List<SavingsAccount> allSavingsAccounts = em.createNamedQuery("SavingsAccount.findAll", SavingsAccount.class)
				.getResultList();
		allSavingsAccounts.forEach(account -> account.deposit(100));
		
		em.getTransaction().begin();
		allSavingsAccounts.forEach(account -> em.merge(account));
		em.getTransaction().commit();
		
		bankAccounts.forEach(account -> System.out.println(account));
//		System.out.println(person1.getAccounts());
//		System.out.println(savingsAccount1.getCustomer());
		
		em.close();
		emf.close();
		
	}

}
