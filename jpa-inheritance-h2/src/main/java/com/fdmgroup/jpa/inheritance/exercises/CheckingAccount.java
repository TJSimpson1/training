package com.fdmgroup.jpa.inheritance.exercises;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("CHECKING")
public class CheckingAccount extends BankAccount {

	CheckingAccount(){}
	
	public CheckingAccount(double balance, BankCustomer customer) {
		super(balance, customer);
	}

	@Override
	public void withdraw(double amount) {
	}

	
	
	

}
