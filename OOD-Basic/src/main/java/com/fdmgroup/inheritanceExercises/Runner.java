package com.fdmgroup.inheritanceExercises;

public class Runner {

	public static void main(String[] args) {
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
		

	}

}
