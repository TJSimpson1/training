package com.fdmgroup.springwebexercise1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.fdmgroup.springwebexercise1.model.User;
import com.fdmgroup.springwebexercise1.service.UserService;

@Controller
public class RegisterController {
	
	private UserService userService;
	
	@Autowired
	public RegisterController(UserService userService) {
		super();
		this.userService = userService;
	}
	
	@GetMapping("/register-user")
	public String displayRegisterUser(Model model, @ModelAttribute User user) {
		model.addAttribute("user", new User());
		
		if(user != null) {
			model.addAttribute("user", user);
		}
		return "registeruser";
	}
	

	@GetMapping("/show-users")
	public String displayShowUsers(Model model) {
		model.addAttribute("users", userService.listUsers());
		return "showUsers";
	}

	@PostMapping("processUser")
	public String handleProcessUser(@ModelAttribute User user, RedirectAttributes redirectAttributes) {
//		System.out.println("Username: " + user.getUsername());
		if (userService.addUser(user) == null) {
			redirectAttributes.addFlashAttribute("user", user);
			redirectAttributes.addFlashAttribute("errorMessage", "Unable to add user, check username doesn't exist and password not empty");
			return "redirect:/register-user";
		}
		System.out.println("List of users: " + userService.listUsers());
//		userDao.findAll().forEach(eachUser -> System.out.println(eachUser.getfName() + " " + eachUser.getlName() + ": " + eachUser.getUsername()));
		return "confirmation";
	}
	
	@GetMapping("delete-user")
	public String handleDeleteUser(Model model, @RequestParam("username") String username, @ModelAttribute User user) {
		userService.deleteUser(username);
		return "redirect:/show-users";
	}
	
	@GetMapping("edit-user")
	public String displayEditUser(Model model, @RequestParam("username") String username, @ModelAttribute User user) {
		model.addAttribute("user", userService.getUser(username));
		return "editUser";
	}
	
	@PostMapping("submit-edit-user")
	public String handleSubmitEditUser(@ModelAttribute User user, RedirectAttributes redirectAttributes) {
//		if(userService.updateUser(user) == null) {
//			redirectAttributes.addFlashAttribute("user", user);
//			redirectAttributes.addFlashAttribute("errorMessage", "Unable to edit user, enter a password");
//			return "redirect:edit-user";
//		}
		userService.updateUser(user);
		return "redirect:/show-users";
	}
	
}
