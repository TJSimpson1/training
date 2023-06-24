package com.fdmgroup.lambdaExercises;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

import com.fdmgroup.lambdas.Product;

public class Runner {

	public static void main(String[] args) {

		BankAccount account1 = new BankAccount(12345678, 987654, "Mr J Smith", "savings", 1.1, 25362.91);
		BankAccount account2 = new BankAccount(87654321, 234567, "Ms J Jones", "current", 0.2, 550);
		BankAccount account3 = new BankAccount(74639572, 946284, "Dr T Williams", "savings", 1.1, 4763.32);
		BankAccount account4 = new BankAccount(94715453, 987654, "Ms S Taylor", "savings", 1.1, 10598.01);
		BankAccount account5 = new BankAccount(16254385, 234567, "Mr P Brown", "current", 0.2, -195.74);
		BankAccount account6 = new BankAccount(38776543, 946284, "Ms F Davies", "current", 0.2, -503.47);
		BankAccount account7 = new BankAccount(87609802, 987654, "Mr B Wilson", "savings", 1.1, 2.5);
		BankAccount account8 = new BankAccount(56483769, 234567, "Dr E Evans", "current", 0.2, -947.72);

		List<BankAccount> bankAccounts = new ArrayList<>(
				Arrays.asList(account1, account2, account3, account4, account5, account6, account7, account8));

		System.out.println("=====1.2.1 Function=====");

		Function<BankAccount, String> getCustomerNameAndBalance = account -> account.getAccountHolder() + ": "
				+ account.getBalance();

		String test1 = getCustomerNameAndBalance.apply(account3);
		String test2 = getCustomerNameAndBalance.apply(account4);

		System.out.println(test1);
		System.out.println(test2);

		System.out.println("=====1.2.2 Function=====");

		Function<BankAccount, Double> getInterest = account -> account.getBalance() * account.getInterestRate() / 100;

		double interestDue = getInterest.apply(account2);
		System.out.println(interestDue);

		System.out.println("=====1.2.3 Function=====");

		Function<BankAccount, Double> getInterestNoOverdraws = account -> account.getBalance() > 0
				? account.getBalance() * account.getInterestRate() / 100
				: 0;

		double interestNoOverdrawDue1 = getInterestNoOverdraws.apply(account2);
		double interestNoOverdrawDue2 = getInterestNoOverdraws.apply(account8);

		System.out.println(interestNoOverdrawDue1);
		System.out.println(interestNoOverdrawDue2);

		System.out.println("=====1.2.4 Predicate=====");

		Predicate<BankAccount> getCurrentAccount = account -> account.getAccountType() == "current";

		boolean current1 = getCurrentAccount.test(account1);
		boolean current2 = getCurrentAccount.test(account8);

		System.out.println(current1);
		System.out.println(current2);

		System.out.println("=====1.2.5 Predicate=====");

		Predicate<BankAccount> getOverdrawnBalance = account -> account.getBalance() < 0;

		boolean overdrawn1 = getOverdrawnBalance.test(account5);
		boolean overdrawn2 = getOverdrawnBalance.test(account7);

		System.out.println(overdrawn1);
		System.out.println(overdrawn2);

		System.out.println("=====1.2.6 BinaryOperator=====");

		BinaryOperator<BankAccount> getHighestBalance = (accountOne,
				accountTwo) -> accountOne.getBalance() > accountTwo.getBalance() ? accountOne : accountTwo;

		BankAccount higherAccount = getHighestBalance.apply(account3, account4);

		System.out.println("Balance is " + higherAccount.getBalance());

		System.out.println("=====1.2.7 Consumer=====");

		Consumer<BankAccount> deduct10FromBalance = account -> account.setBalance(account.getBalance() - 10);

		deduct10FromBalance.accept(account2);
		deduct10FromBalance.accept(account6);

		System.out.println(account2.getBalance());
		System.out.println(account6.getBalance());

		System.out.println("=====1.2.8 BiConsumer=====");

		BiConsumer<BankAccount, Integer> deductFromBalance = (account, num) -> account
				.setBalance(account.getBalance() - num);

		deductFromBalance.accept(account1, 100);
		deductFromBalance.accept(account5, 50);

		System.out.println(account1.getBalance());
		System.out.println(account5.getBalance());
		
		System.out.println("\n=========================1.3=========================");
		Consumer<BankAccount> printMainInfo = person -> System.out.println(person.getAccountHolder() + ": " + person.getAccountNumber()
				+ ". Account type: " + person.getAccountType() + ". Balance: " + person.getBalance());

		System.out.println("\n=========================1.3.2 forEach=========================");
		bankAccounts.forEach(printMainInfo);
		
		System.out.println("\n=========================1.3.3 forEach=========================");
		bankAccounts.forEach(deduct10FromBalance);
		bankAccounts.forEach(printMainInfo);
		
		System.out.println("\n=========================1.3.4 removeIf=========================");
		bankAccounts.removeIf(person -> person.getBalance() < -500);
		bankAccounts.forEach(printMainInfo);
		
		System.out.println("\n=========================1.3.5 removeIf=========================");
		bankAccounts.removeIf(getCurrentAccount.negate());
		bankAccounts.forEach(printMainInfo);
		
		
		System.out.println("\n=========================1.4 Comparators=========================");
		bankAccounts.addAll(Arrays.asList(account1,account3,account4,account6,account7,account8));
		
		System.out.println("\n=========================1.4.1 Balance Comparator=========================");
		Comparator<BankAccount> sortByBalance =
				(accountOne, accountTwo) -> ((Double) accountOne.getBalance()).compareTo(accountTwo.getBalance()); 
		
		bankAccounts.sort(sortByBalance);
		bankAccounts.forEach(printMainInfo);
		
		System.out.println("\n=========================1.4.2 Account Type Comparator=========================");
		Comparator<BankAccount> sortByAccountType =
				(accountOne, accountTwo) -> accountOne.getAccountType().compareTo(accountTwo.getAccountType());
		
		bankAccounts.sort(sortByAccountType);
		bankAccounts.forEach(printMainInfo);
		
		System.out.println("\n=========================1.4.3 Account Number Comparator=========================");
		Comparator<BankAccount> sortByAccountNumber =
				(accountOne, accountTwo) -> ((Integer) accountOne.getAccountNumber()).compareTo(accountTwo.getAccountNumber()); 
		
		bankAccounts.sort(sortByAccountNumber);
		bankAccounts.forEach(printMainInfo);
		
		System.out.println("\n=========================1.4.4 Combined Comparator=========================");
		Comparator<BankAccount> sortByAccountTypeThenByBalance =
				sortByAccountType.thenComparing(sortByBalance);
		
		bankAccounts.sort(sortByAccountTypeThenByBalance);
		bankAccounts.forEach(printMainInfo);
		
		System.out.println("\n=========================1.5 Map.merge()=========================");
		Map<Integer, Integer> accountsInBankCode = new HashMap<>();
		
		System.out.println("\n=========================1.5.1 Bank Code Counter=========================");
		
		BiFunction<Integer, Integer, Integer> remappingFunction =
				(currentAmount, amountToAdd) -> currentAmount + amountToAdd;
		
		for(BankAccount account : bankAccounts) {
			accountsInBankCode.merge(account.getBankCode(), 1, remappingFunction);
		}
		
		for(Integer bankCode : accountsInBankCode.keySet()) {
			System.out.println(bankCode + ": " + accountsInBankCode.get(bankCode));
		}
		
		System.out.println("\n=========================1.5.3 Bank Code Balance Sum=========================");
		
		Map<Integer, Double> balanceSumInBankCode = new HashMap<>();
		
		BiFunction<Double, Double, Double> remappingFunction2 =
				(currentAmount, amountToAdd) -> currentAmount + amountToAdd;
				
		for(BankAccount account : bankAccounts) {
			balanceSumInBankCode.merge(account.getBankCode(), account.getBalance(), remappingFunction2);
		}
		
		for(Integer bankCode : balanceSumInBankCode.keySet()) {
			System.out.println(bankCode + ": " + balanceSumInBankCode.get(bankCode));
		}
		

	}

}
