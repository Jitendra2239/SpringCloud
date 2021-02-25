package com.wipro.cruddemo.service;


import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.mockito.MockitoAnnotations.Mock;
import org.mockito.junit.MockitoJUnitRunner;


import com.wipro.cruddemo.model.Employee;
import com.wipro.cruddemo.repository.EmployeeRepository;

@RunWith(MockitoJUnitRunner.class)
public class EmployeeServiceTest {
	

	@InjectMocks
private EmployeeService empservice;
	
	@Mock
	EmployeeRepository repo;

	
	
	
	@Before
	public void init()
	{
		MockitoAnnotations.initMocks(this);
	}

	
	@Test
    public void getAllEmployeesTest()
    {
        List<Employee> list = new ArrayList<Employee>();
        Employee empOne = new Employee(1, "RAJ", "C1", 200000);
        Employee empTwo = new Employee(2, "DAKSHITH", "B1", 200000); 
        Employee empThree = new Employee(3, "KIRAN", "B1", 200000);
        
        list.add(empOne);
        list.add(empTwo);
        list.add(empThree);
        init();
        when( repo.findAll()).thenReturn(list);
         
        //test
        List<Employee> empList = empservice.getAllEmployees();
         
       assertEquals(3, empList.size());
      //  System.out.print(empList.size());
       // verify(repo, times(1)).findAll();
    }

	
	
	
	//-----------
	/*

	@InjectMocks
	EmployeeService empservice;
	
	@Mock
	EmployeeRepository repo;
	
	
	
	
	
	@Test
    public void getAllEmployeesTest()
    {
        List<Employee> list = new ArrayList<Employee>();
        Employee empOne = new Employee(1, "RAJ", "C1", 200000);
        Employee empTwo = new Employee(2, "DAKSHITH", "B1", 200000); 
        Employee empThree = new Employee(3, "KIRAN", "B1", 200000);
        
        list.add(empOne);
        list.add(empTwo);
        list.add(empThree);
        
        when(repo.findAll()).thenReturn(list);
         
        //test
        List<Employee> empList = empservice.getAllEmployees();
         
        assertEquals(3, empList.size());
        verify(repo, times(1)).findAll();
    }

@Ignore
	@Test
    public void getEmployeeByIdTest()
    {
	//	Optional<Employee> e=new Optional<Employee>();
		
		
      when(repo.findById(1).get()).thenReturn(new Employee(1,"ABCD","B1",20000));

        Employee emp = empservice.getEmployeeById(1);
         
        assertEquals(1, emp.getEmpid());
        
        assertEquals("ABCD", emp.getEmpname());
        assertEquals("B1", emp.getEmpband());
    }
	
	
	@Test
    public void createEmployeeTest()
    {
        Employee emp = new Employee(1,"ABCD","B3",100000);
   
  
        
        empservice.saveOrUpdate(emp);
         
   
        verify(repo, times(1)).save(emp);
    }
	
	
	
	@Test
    public void deleteEmployeetest()
    {
        //Employee emp = new Employee(1,"ABCD","B3",100000);
         
        empservice.delete(1);
         
        verify(repo, times(1)).deleteById(1);
        
  
    }
*/

}
