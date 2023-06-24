package com.fdmgroup.polymorphismExercises;

public class Runner {

	public static void main(String[] args) {
		System.out.println("==============================================");
		System.out.println("            INHERITANCE  EXERCISES            ");
		System.out.println("==============================================");
		
		AdminUser adminUser1 = new AdminUser("travis2215", "password1", "Travis Simpson");
		AdminUser adminUser2 = new AdminUser("hollyg0612", "This15APassw0rd!", "Holly Grinnell");
		
		Customer customer1 = new Customer("johntheman", "sparkles5", "John Doe");
		Customer customer2 = new Customer("janethewoman", "qwerty", "Jane Doe");
		
		System.out.println(adminUser1.getFullName() + " has username " + adminUser1.getUsername() + " with password " + adminUser1.getPassword());
		System.out.println(customer1.getFullName() + " has username " + customer1.getUsername() + " with password " + customer1.getPassword());
		
		adminUser1.changePassword("asrgfasfga", "asrgfasfga");
		customer1.changePassword("asdifj;auwrgn", "348uiwurhsdf");
		
		System.out.println(adminUser1.getFullName() + " has username " + adminUser1.getUsername() + " with password " + adminUser1.getPassword());
		System.out.println(customer1.getFullName() + " has username " + customer1.getUsername() + " with password " + customer1.getPassword());
		
		adminUser2.accessWebsite();
		customer2.accessWebsite();
		
		UserAccountManager userAccountManager = new UserAccountManager();
		userAccountManager.addUser(adminUser1);
		userAccountManager.addUser(adminUser2);
		userAccountManager.addUser(customer1);
		userAccountManager.addUser(customer2);
		
		
		userAccountManager.login("travis2215", "asrgfasfga");
		
		userAccountManager.login("hollyg0612", "sparkles5");
		
		System.out.println("==============================================");
		System.out.println("            POLYMORPHISM EXERCISES            ");
		System.out.println("==============================================");
		
		AdminUser.setMinAdminPasswordLength(10);
		
		//Doesn't meet overriden criteria in AdminUser method
		adminUser1.changePassword("1234567", "1234567");
		System.out.println(adminUser1.getFullName() + " has username " + adminUser1.getUsername() + " with password " + adminUser1.getPassword());
		
		adminUser1.changePassword("0123456789", "0123456789");
		System.out.println(adminUser1.getFullName() + " has username " + adminUser1.getUsername() + " with password " + adminUser1.getPassword());

		adminUser1.changePassword("AdminChangedPassword", "AdminChangedPassword", customer1);
		System.out.println(customer1.getFullName() + " has username " + customer1.getUsername() + " with password " + customer1.getPassword());
		
		Customer.setMinCustomerPasswordLength(7);
		
		customer1.changePassword("123456", "123456");
		System.out.println(customer1.getFullName() + " has username " + customer1.getUsername() + " with password " + customer1.getPassword());
		
		customer1.changePassword("1234567", "1234567");
		System.out.println(customer1.getFullName() + " has username " + customer1.getUsername() + " with password " + customer1.getPassword());
		
		
	}

}
