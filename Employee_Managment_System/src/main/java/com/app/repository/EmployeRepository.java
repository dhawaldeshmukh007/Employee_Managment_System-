package com.app.repository;

import org.springframework.data.repository.CrudRepository;


import com.app.entity.Employee;

/*Here We Create Repository layer that is DAO layer*/

public interface EmployeRepository extends CrudRepository<Employee, Integer> {
	
	public Employee findById(int id);
	public Employee findByEmail(String email);
	public Employee findByName(String name);
}
