package com.wipro.cruddemo.service;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import com.wipro.cruddemo.CrudRepositoryJpaApplication;
import com.wipro.cruddemo.model.Employee;
import com.wipro.cruddemo.repository.EmployeeRepository;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Service
public class EmployeeService {
@Autowired
EmployeeRepository employeerepository;
public List<Employee> getAllEmployees()
{
	
	List<Employee> employees = new ArrayList<Employee>(); 
	employeerepository.findAll().forEach(employees1 ->employees.add(employees1));  
	return employees;  
}


public Employee getEmployeeById(int id)   
{  
return employeerepository.findById(id).get();  
}  

//saving a specific record by using the method save() of CrudRepository  
public void saveOrUpdate(Employee employee)   
{  
employeerepository.save(employee);  
}  

//deleting a specific record by using the method deleteById() of CrudRepository  
public void delete(int id)   
{  
employeerepository.deleteById(id);  
}  

//updating a record  
public void update(Employee employee, int employeeid)   
{  
employeerepository.save(employee);  
}  
public int add(int x,int y) {
	return x+y;
}

}
