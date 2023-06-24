package com.fdmgroup.jpa.inheritance.exercises;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "BANK_CUSTOMER")
public abstract class BankCustomer {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "bank_customer_gen")
	@SequenceGenerator(name = "bank_customer_gen", sequenceName = "bank_customer_seq", allocationSize = 1)
	@Column(name = "CUSTOMER_ID", nullable = false)
	private int id;
	private String address;
	@OneToMany(mappedBy = "customer")
	private List<BankAccount> accounts = new ArrayList<>();
	
	BankCustomer(){}
	
	public BankCustomer(String address) {
		super();
		this.address = address;
	}
	
	public void addAccount(BankAccount account) {
		accounts.add(account);
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public List<BankAccount> getAccounts() {
		return accounts;
	}
	public void setAccounts(List<BankAccount> accounts) {
		this.accounts = accounts;
	}
	

	@Override
	public String toString() {
		return "[ID=" + getId() + ", Address="
				+ getAddress() + "]";
	}
	
	
	
}
