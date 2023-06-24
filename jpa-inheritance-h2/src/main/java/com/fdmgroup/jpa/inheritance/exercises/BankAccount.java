package com.fdmgroup.jpa.inheritance.exercises;

import javax.persistence.CascadeType;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "ACCOUNT_TYPE")
@Table(name = "BANK_ACCOUNT")
@NamedQuery(name = "BankAccount.findAll", query = "SELECT b FROM BankAccount b")
public abstract class BankAccount {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "bank_account_gen")
	@SequenceGenerator(name = "bank_account_gen", sequenceName = "bank_account_seq", allocationSize = 1)
	@Column(name = "ACCOUNT_ID")
	private int id;
	@Column(name = "BALANCE", nullable = false)
	private double balance;
	@ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	@JoinColumn(name = "FK_CUSTOMER_ID")
	private BankCustomer customer;
	
	BankAccount(){}
	
	public BankAccount(double balance, BankCustomer customer) {
		super();
		this.balance = balance;
		this.customer = customer;
		customer.addAccount(this);
//		customer.getAccounts.add(this); //Alternative
	}

	public void deposit(double amount) {
		balance += amount;
	}
	
	public abstract void withdraw(double amount);
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public BankCustomer getCustomer() {
		return customer;
	}
	public void setCustomer(BankCustomer customer) {
		this.customer = customer;
	}
	
	@Override
	public String toString() {
		return "CheckingAccount [ID=" + getId() + ", Balance=" + getBalance() + ", Customer="
				+ getCustomer() + "]";
	}
	
	
}
