package com.fdmgroup.employeeUITravisSimpson.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.fdmgroup.employeeUITravisSimpson.exception.InvalidEmployeeException;
import com.fdmgroup.employeeUITravisSimpson.model.Employee;
import com.fdmgroup.employeeUITravisSimpson.service.FeignEmployeeService;

@Controller
public class EmployeeController {
	
	private final FeignEmployeeService employeeService;

	public EmployeeController(FeignEmployeeService employeeService) {
		super();
		this.employeeService = employeeService;
	}
	
	@GetMapping("getHome")
	public String getHome() {
		return "index";
	}
	
	@RequestMapping("allEmployees")
	public String allEmployees(Model model) {
		model.addAttribute("listOfEmployees", employeeService.getAllEmployees());
		return "all-employees";
	}
	
	@GetMapping("addNewEmployee")
	public String addEmployee(Model model) {
		model.addAttribute("employee", new Employee());
		return "add-employee";
	}
	
	@PostMapping("addEmployeeSubmit")
	public String addEmployeeSubmit(@ModelAttribute Employee employee) {
		employeeService.addEmployee(employee);
		return "forward:/allEmployees";
	}
	
	@GetMapping("viewAllInfo")
	public String viewAllInfo(@RequestParam int id, Model model) {
		Employee employee = employeeService.getEmployeeById(id);
		model.addAttribute("employee", employee);
		return "view-all-info";
	}
	
	@GetMapping("editEmployee")
	public String editEmployee(@RequestParam int id, Model model) {
		Employee employee = employeeService.getEmployeeById(id);
		model.addAttribute("employee", employee);
		return "edit-employee";
	}
	
	@PostMapping("editEmployeeSubmit")
	public String editEmployeeSubmit(@ModelAttribute Employee employee) {
		employeeService.updateEmployee(employee, employee.getId());
		return "forward:/allEmployees";
	}
	
	@GetMapping("deleteEmployee")
	public String deleteEmployee(@RequestParam int id) {
		employeeService.deleteEmployee(id);
		return "forward:/allEmployees";
	}
	
	@GetMapping("search-by-first-name")
	public String searchEmployeesFirstByName(@RequestParam String firstName, Model model) {
		model.addAttribute("listOfEmployees", employeeService.listEmployeesByFirstName(firstName));
		return "all-employees";
	}
	
	@GetMapping("search-by-last-name")
	public String searchEmployeesByLastName(@RequestParam String lastName, Model model) {
		model.addAttribute("listOfEmployees", employeeService.listEmployeesByLastName(lastName));
		return "all-employees";
	}
	
	@ExceptionHandler(InvalidEmployeeException.class)
	public String handleInvalidEmployeeException(InvalidEmployeeException ex, Model model) {
		model.addAttribute("validationErrors", ex.getErrorMessages());
		return addEmployee(model);
	}

}
