package com.fdmgroup.userclient.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.fdmgroup.userclient.exception.GenericUserException;
import com.fdmgroup.userclient.exception.InvalidUserException;
import com.fdmgroup.userclient.model.User;
import com.fdmgroup.userclient.service.WebClientUserService;

@Controller
public class UserController {
	
	private final WebClientUserService userService;

	public UserController(WebClientUserService userService) {
		super();
		this.userService = userService;
	}
	
	@PostMapping("login")
	public String handleLogin(@RequestParam String username, @RequestParam String password, Model model) {
		if(userService.verifyPassword(username, password)) {
			model.addAttribute("listOfUsers", userService.getAllUsers());
			return "index";
		}
		return "index";
	}
	
	@GetMapping("registerUser")
	public String registerUser(Model model) {
		model.addAttribute("user", new User());
		return "registration";
	}
	
	@PostMapping("registerUserSubmit")
	public String registerUserSubmit(@ModelAttribute User user) {
		userService.addUser(user);
		return "index";
	}
	
	@ExceptionHandler(GenericUserException.class)
	public String handleGenericUserException(GenericUserException ex, Model model) {
		model.addAttribute("errorCode", ex.STATUS);
		model.addAttribute("errorMessage", ex.getMessage());
		return "error-page";
	}
	
	@ExceptionHandler(InvalidUserException.class)
	public String handleInvalidUserException(InvalidUserException ex, Model model) {
		model.addAttribute("validationErrors", ex.getErrorMessages());
		return registerUser(model);
	}

}
