package com.wipro.cruddemo.repository;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.wipro.cruddemo.model.Employee;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@DataJpaTest

class EmployeeRepositoryTest {

	@Autowired
	EmployeeRepository repository;

	@Test
	public void createRepositoryTest() 
	{
		Employee emp = new Employee();
		emp.setEmpid(100);
		emp.setEmpname("DAKSHITH");
		emp.setEmpband("C2");
		emp.setEmpsal(250000);
		
		repository.save(emp);
		
		System.out.println(emp);
		
		 assertThat(emp.getEmpid()).isNotEqualTo(null);
		
		List<Employee> employees = new ArrayList<Employee>(); 
		repository.findAll().forEach(employees1 ->employees.add(employees1));
		System.out.println(emp);
		assertEquals(1, employees.size());
		
		
		
	}

	
	@Test
	public void getAllEmployeesTest() 
	{
		List<Employee> employees = (List<Employee>) repository.findAll();
		//repository.findAll().forEach(employees1 ->employees.add(employees1));
		
		assertEquals(0, employees.size());
		
		Employee emp = new Employee();
		emp.setEmpid(100);
		emp.setEmpname("DAKSHITH");
		emp.setEmpband("C2");
		emp.setEmpsal(250000);
		
		repository.save(emp);
		
		List<Employee> employees1=(List<Employee>) repository.findAll();
		assertEquals(1, employees1.size());
	//	Assert.assertNotNull(emp.getEmpid());
		
		
		
	}
	
}
