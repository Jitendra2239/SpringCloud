package com.wipro.cruddemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.wipro.cruddemo.service.EmployeeService;
import com.wipro.cruddemo.model.Employee;

@RestController

public class EmployeeController {

	@Autowired
	EmployeeService employeeservice;
	@GetMapping("/employees")
	public List<Employee> getAllEmployees() {
	return employeeservice.getAllEmployees();
		}
	@GetMapping("/hello")
	public String hello()
	{
		return "Welcome to TestController";
	}
	
	@GetMapping("/employee/{empid}")
	public Employee getEmployeeById(@PathVariable("empid") int empid)
	{
		return employeeservice.getEmployeeById(empid);
	}
	
	//creating a delete mapping that deletes a specified employee
	@DeleteMapping("/employee/{empid}")  
	private void deleteEmployee(@PathVariable("empid") int empid)   
	{  
	 employeeservice.delete(empid);  
	}  
	
	
	//creating post mapping that post the book detail in the database  
	@PostMapping("/employee")  
	private int saveEmployee(@RequestBody Employee employee)   
	{  
	 employeeservice.saveOrUpdate(employee);
	 return employee.getEmpid();
	
	}	
	
	//creating put mapping that updates the employee detail   
	@PutMapping("/employee")  
	private Employee update(@RequestBody Employee employee)   
	{  
	employeeservice.saveOrUpdate(employee);  
	return employee;  
	}  
}
