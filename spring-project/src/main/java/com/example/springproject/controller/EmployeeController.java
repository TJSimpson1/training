package com.example.springproject.controller;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.springproject.model.Employee;
import com.example.springproject.service.EmployeeService;

@Controller
public class EmployeeController {
	
	private EmployeeService employeeService;
	
	
	private Logger logger = LogManager.getLogger(EmployeeController.class);

	@Autowired
	public EmployeeController(EmployeeService employeeService) {
		super();
		this.employeeService = employeeService;
	}
	
	/**
	 Creates new employee object and binds it to the database. Then displays the add employee page.
	 @param model stores employee object
	 @param employee model attribute reads data entered into the form
	 @return {@code "addEmployee"} displays add employee page
	 */
	@GetMapping("/add-employee")
	public String displayAddEmployee(Model model, @ModelAttribute Employee employee) {
		logger.trace("Entering displayAddEmployee method");
		model.addAttribute("employee", new Employee());
		
		if(employee != null) {
			model.addAttribute("employee", employee);
		}
		logger.trace("Exiting displayAddEmployee method");
		return "addEmployee";
	}
	
	/**
	 Redirects back to /add-employee if {@code employeeService.addEmployee(employee)==null}, otherwise redirects to /show-employees
	 @param employee model attribute reads data entered into the form
	 @param redirectAttributes handles error messages and maintaining data in HTML form
	 @return {@code "redirect:/add-employee"} displays same HTML form with error message if one or more form field is blank,
	 			otherwise {@code "redirect:/show-employees"} displays all employees page
	 */
	@PostMapping("add-new-employee")
	public String handleAddNewEmployee(@ModelAttribute Employee employee, RedirectAttributes redirectAttributes)	{
		logger.trace("Entering handleAddNewEmployee method");
		if(employeeService.addEmployee(employee) == null) {
			redirectAttributes.addFlashAttribute("employee", employee);
			redirectAttributes.addFlashAttribute("errorMessage", "Enter all fields");
			return "redirect:/add-employee";
		}
		logger.trace("Exiting handleAddNewEmployee method");
		return "redirect:/show-employees";
	}
	
	/**
	 Connects list of employees with the employees in database, then displays the show employees page.
	 @param model stores list of employees
	 @return {@code "showEmployees"} displays show employees page
	 */
	@GetMapping("show-employees")
	public String displayShowEmployees(Model model) {
		logger.trace("Entering displayShowEmployees method");
		model.addAttribute("employees", employeeService.listEmployees());
		logger.trace("Exiting displayShowEmployees method");
		return "showEmployees";
	}
	
	/**
	 Displays page showing the list of employees with address containing String argument (case-insensitive)
	 @param model stores list of employees with a compatible address
	 @param address receives parameter from form and is passed into search method
	 @return {@code "showEmployees"} displays show employees page containing valid employees based on the search
	 */
	@PostMapping("search-by-address")
	public String handleSearchByAddress(Model model, @RequestParam("address") String address) {
		logger.trace("Entering handleSearchByAddress method");
		model.addAttribute("employees", employeeService.listEmployeesByAddress(address));
		logger.trace("Exiting handleSearchByAddress method");
		return "showEmployees";
	}
	
	/**
	 Displays page showing the list of employees with first name matching String argument (case-insensitive)
	 @param model stores list of employees with a first name matching the String argument
	 @param firstName receives parameter from form and is passed into search method
	 @return {@code "showEmployees"} displays show employees page containing valid employees based on the search
	 */
	@PostMapping("search-by-first-name")
	public String handleSearchByFirstName(Model model, @RequestParam("firstName") String firstName) {
		logger.trace("Entering handleSearchByFirstName method");
		model.addAttribute("employees", employeeService.listEmployeesByFirstName(firstName));
		logger.trace("Exiting handleSearchByFirstName method");
		return "showEmployees";
	}
	
	/**
	 Displays page showing the list of employees with last name matching String argument (case-insensitive)
	 @param model stores list of employees with a last name matching the String argument
	 @param lastName receives parameter from form and is passed into search method
	 @return {@code "showEmployees"} displays show employees page containing valid employees based on the search
	 */
	@PostMapping("search-by-last-name")
	public String handleSearchByLastName(Model model, @RequestParam("lastName") String lastName) {
		logger.trace("Entering handleSearchByLastName method");
		model.addAttribute("employees", employeeService.listEmployeesByLastName(lastName));
		logger.trace("Exiting handleSearchByLastName method");
		return "showEmployees";
	}
	

}
