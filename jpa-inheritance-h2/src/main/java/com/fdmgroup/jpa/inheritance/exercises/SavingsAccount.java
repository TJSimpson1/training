package com.fdmgroup.jpa.inheritance.exercises;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.NamedQuery;

@Entity
@DiscriminatorValue("SAVINGS")
@NamedQuery(name = "SavingsAccount.findAll", query = "SELECT s FROM SavingsAccount s")
public class SavingsAccount extends BankAccount {
	
	SavingsAccount(){}
	
	public SavingsAccount(double balance, BankCustomer customer) {
		super(balance, customer);
	}

	@Override
	public void withdraw(double amount) {
	}
	

}
