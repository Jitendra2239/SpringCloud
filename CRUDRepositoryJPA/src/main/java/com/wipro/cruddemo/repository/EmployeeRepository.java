package com.wipro.cruddemo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.wipro.cruddemo.model.Employee;
@Repository
public interface EmployeeRepository extends CrudRepository<Employee, Integer>{
  
	
}
