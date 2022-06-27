package com.app.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;

import org.springframework.lang.NonNull;


/*Here we create pojo class for Employee with its Employee Id,Employee Name,Employee Email,Employee Phone*/

@Entity
@Table(name="employee")
public class Employee {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="emp_id")
	
	private int id; 
	
	
	@Column(name="name")/* Employee Name */
	@NonNull
	private String name;
	
	@Column(name="email")/* Employee Email */
	@Email
	private String email;
	
	@Column(name="phone")/* Employee Phone */
	@NonNull
	private String phone;

	public Employee() { /* defaullt constructor */ 
		
	}

	public Employee(int id, String name, String email, String phone) {/* Paramaterized constructor */ 
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.phone = phone;
	}

	
	/* setters and getters */
	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	
	/* To String */
	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", email=" + email + ", phone=" + phone + "]";
	}
	
	
	
	

}
