package com.fdmgroup.streamsExercises;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import com.fdmgroup.lambdaExercises.BankAccount;

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

		System.out.println("========================================================================");
		System.out.println("============================Section 1.2=================================");
		System.out.println("========================================================================");

		Predicate<BankAccount> currentAccounts = account -> account.getAccountType() == "current";

		long numberOfCurrentAccounts = bankAccounts.stream().filter(currentAccounts).count();
		System.out.println("Number of current accounts is " + numberOfCurrentAccounts);

		Predicate<BankAccount> overdrawnAccounts = account -> account.getBalance() < 0;

		long numberOfOverdrawnAccounts = bankAccounts.stream().filter(overdrawnAccounts).count();
		System.out.println("Number of overdrawn accounts is " + numberOfOverdrawnAccounts);

		OptionalDouble highestBalance = bankAccounts.stream().mapToDouble(account -> account.getBalance()).max();
		highestBalance.ifPresent(balance -> System.out.println("Highest balance is: " + balance));

		OptionalDouble averageBalance = bankAccounts.stream().mapToDouble(account -> account.getBalance()).average();
		averageBalance.ifPresent(balance -> System.out.println("Average balance is: " + balance));

		OptionalDouble averageNegativeBalance = bankAccounts.stream().filter(overdrawnAccounts)
				.mapToDouble(account -> account.getBalance()).average();
		averageNegativeBalance.ifPresent(balance -> System.out.println("Average negative balance is: " + balance));

		OptionalDouble averagePositiveBalance = bankAccounts.stream().filter(overdrawnAccounts.negate())
				.mapToDouble(account -> account.getBalance()).average();
		averagePositiveBalance.ifPresent(balance -> System.out.println("Average positive balance is: " + balance));

		double sumNegativeBalances = bankAccounts.stream().filter(overdrawnAccounts)
				.mapToDouble(account -> account.getBalance()).sum();
		System.out.println("Sum of negative balances is: " + sumNegativeBalances);

		double totalInterestDue = bankAccounts.stream().filter(overdrawnAccounts.negate())
				.mapToDouble(account -> account.getBalance() * account.getInterestRate() / 100).sum();
		System.out.println("Total interest due: " + totalInterestDue);

		System.out.println("========================================================================");
		System.out.println("============================Section 1.3=================================");
		System.out.println("========================================================================");
		Consumer<BankAccount> printMainInfo = person -> System.out.println(person.getAccountHolder()
				+ ". Interest rate: " + person.getInterestRate() + ". Account type: " + person.getAccountType()
				+ ". Bank code: " + person.getBankCode() + ". Balance: " + person.getBalance());

		System.out.println("========== Overdrawn List ==========");
		List<String> listOfOverdrawn = bankAccounts.stream().filter(overdrawnAccounts)
				.map(account -> account.getAccountHolder()).collect(Collectors.toList());
		listOfOverdrawn.forEach(account -> System.out.println(account));

		Predicate<BankAccount> savingsAccounts = account -> account.getAccountType() == "savings";
		Consumer<BankAccount> newInterest = account -> account.setInterestRate(1.3);

		List<BankAccount> savingsAccountsList = bankAccounts.stream().filter(savingsAccounts).toList();
		savingsAccountsList.forEach(newInterest);
//		bankAccounts.forEach(printMainInfo);

		Predicate<BankAccount> bankCodes234567 = account -> account.getBankCode() == 234567;
		Consumer<BankAccount> newBankCode = account -> account.setBankCode(123456);

		List<BankAccount> bankCodes234567List = bankAccounts.stream().filter(bankCodes234567)
				.collect(Collectors.toList()); // Collectors allows us to modify the list, just using .toList() returns
												// an unmodifiable list
		bankCodes234567List.forEach(newBankCode);
//		bankAccounts.forEach(printMainInfo);

		System.out.println("========== Bank code 987654 List ==========");
		Predicate<BankAccount> bankCodes987654 = account -> account.getBankCode() == 987654;
		List<BankAccount> bankCodes987654List = bankAccounts.stream().filter(bankCodes987654).toList();
		bankCodes987654List
				.forEach(account -> System.out.println(account.getAccountHolder() + ": " + account.getBankCode()));

		Predicate<BankAccount> drAccountHolder = account -> account.getAccountHolder().substring(0, 2).equals("Dr");
		List<BankAccount> drAccountHoldersList = bankAccounts.stream().filter(drAccountHolder).toList();
		System.out.println("========== Drs List ==========");
		drAccountHoldersList.forEach(account -> System.out.println(account.getAccountHolder()));

		System.out.println("========================================================================");
		System.out.println("============================Section 1.4=================================");
		System.out.println("========================================================================");

		BinaryOperator<BankAccount> getHighestBalance = (accountOne,
				accountTwo) -> accountOne.getBalance() > accountTwo.getBalance() ? accountOne : accountTwo;

		Optional<BankAccount> highestBalanceAccount = bankAccounts.stream().reduce(getHighestBalance);
		highestBalanceAccount.ifPresent(account -> System.out
				.println("Highest balance account is " + account.getAccountHolder() + ": £" + account.getBalance()));

		BinaryOperator<BankAccount> getLowestBalance = (accountOne,
				accountTwo) -> accountOne.getBalance() < accountTwo.getBalance() ? accountOne : accountTwo;
		Optional<BankAccount> lowestBalanceAccountWith987654SortCode = bankCodes987654List.stream()
				.reduce(getLowestBalance);
		lowestBalanceAccountWith987654SortCode
				.ifPresent(account -> System.out.println("Lowest balance account with bank code "
						+ account.getBankCode() + " is " + account.getAccountHolder() + ": £" + account.getBalance()));
	}

}
