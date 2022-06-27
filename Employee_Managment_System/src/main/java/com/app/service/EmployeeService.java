package com.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.app.entity.Employee;
import com.app.repository.EmployeRepository;

@Component
public class EmployeeService {

	@Autowired
	EmployeRepository employeRepository;

	public List<Employee> getAllEmployee() {
		List<Employee> list = (List<Employee>) this.employeRepository.findAll();

		return list;
	}

	public Employee getEmployeeById(int id) {
		Employee employee = null;
		employee = this.employeRepository.findById(id);
		employee = this.employeRepository.findById(id);
		return employee;
	}
	
	public Employee getEmployeeByEmail(String email) {
		Employee employee = null;
		employee = this.employeRepository.findByEmail(email);
		employee = this.employeRepository.findByEmail(email);
		return employee;
	}
	
	public Employee getEmployeeByName(String name) {
		Employee employee = null;
		employee = this.employeRepository.findByName(name);
		employee = this.employeRepository.findByName(name);
		return employee;
	}

	public Employee addEmployee(Employee e) {

		Employee result = this.employeRepository.save(e);
		return result;

	}

	public void deleteEmployee(int id) {
		employeRepository.deleteById(id);
	}

	public Employee update(Employee employee) {
		List<Employee> list = (List<Employee>) this.employeRepository.findAll();
		list.forEach(e -> {
			if (e.getId() == employee.getId()) {
				e.setName(employee.getName());
				e.setEmail(employee.getEmail());

			}
		});
		return employee;

	}

}
