package com.app.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import com.app.entity.Employee;
import com.app.repository.EmployeRepository;
import com.app.service.EmployeeService;

/*Front Controller or Dispatcher Servlet
*/

@RestController
public class EmployeeController {
	
	@Autowired
	EmployeeService employeeService;
	
	@Autowired
	EmployeRepository employeRepository;	
	
	To Get All Employees
	@GetMapping("/employees")
	public ResponseEntity<List<Employee>> getAllEmployee() {

		List<Employee> list = employeeService.getAllEmployee();
		if (list.size() <= 0) {

			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.of(Optional.of(list));
	}
	

	/* To Get All Employees By Email */
	@GetMapping("/employee/{email}")
	public ResponseEntity<Employee> getAllBookById(@PathVariable("email") String email) {
		Employee employee1 = employeeService.getEmployeeByEmail(email);
		if (employee1 == null) {

			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.of(Optional.of(employee1));

	}
	
	/* To Get All Employees by Name */
	
	@GetMapping("/employee/{name}")
	public ResponseEntity<Employee> getAllBookByName(@PathVariable("name") String name) {
		Employee employee2 = employeeService.getEmployeeByName(name);
		if (employee2 == null) {

			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.of(Optional.of(employee2));
	}
	
	/* To Add All Employees */
	
	@PostMapping("/employees")
	public ResponseEntity<Employee> addEmployee(@Valid @RequestBody Employee employee) {
		Employee e = null;
		e = this.employeeService.addEmployee(employee);
		System.out.println(employee);
		return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	}
	
	/* To Update All Employees */
	
	  @PutMapping("/employees") public Employee updateEmployee(@Valid  @RequestBody
	  Employee employee) {
	  
	  return this.employeeService.update(employee);
	  
	  
	  
	  }
	 

	
}
