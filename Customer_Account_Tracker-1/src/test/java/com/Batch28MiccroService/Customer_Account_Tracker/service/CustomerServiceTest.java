package com.Batch28MiccroService.Customer_Account_Tracker.service;

import static org.hamcrest.CoreMatchers.any;
import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.doNothing;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.internal.stubbing.answers.DoesNothing;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;

import com.Batch28MiccroService.Customer_Account_Tracker.model.Account;
import com.Batch28MiccroService.Customer_Account_Tracker.model.Customer;
import com.Batch28MiccroService.Customer_Account_Tracker.repository.AccountRepository;
import com.Batch28MiccroService.Customer_Account_Tracker.repository.CustomerRepository;




@RunWith(MockitoJUnitRunner.class)
class CustomerServiceTest {
	@Mock
	CustomerRepository repo;
	@InjectMocks
   CustomerService service;
	@Autowired
	CustomerRepository repo1;
	@Before
	public void init()throws Exception
	{
		MockitoAnnotations.initMocks(this);
	}
	

	

	
		@Test
	void testGetAllCustomer() throws Exception {
		Account acc1=new Account(1,2345,"saving",20);
		//Account acc2=new Account(234,"current",200);
		//Account acc3=new Account(23456,"saving",20222);
		//Account acc4=new Account(2347,"current",20000);
		 List<Account> acclist = new ArrayList<Account>();
		// List<Account> acclist1 = new ArrayList<Account>();
		 acclist.add(acc1);
		// acclist.add(acc2);
		// acclist1.add(acc3);
		// acclist1.add(acc4);
		 List<Customer> list = new ArrayList<Customer>();
		 Customer customer1 = new Customer(1, "RAJ", "banglore","9932043497","123456", acclist);
		 //Customer customer2 = new Customer(2, "raju", "kolkata","456123","654321", acclist1);
	        list.add(customer1);
	        //list.add(customer2);
	        init();
	        when(repo.findAll()).thenReturn(list);
	         
	        //test
	        List<Customer> customerlist = service.getAllCustomer();
	   
	        assertEquals(1,customerlist.size());
	}
    @Test
			void testGetCustomerById() throws Exception {
				Account acc1=new Account(1,234,"saving",20);
				Account acc2=new Account(2,234,"current",200);
				Account acc3=new Account(3,23456,"saving",20222);
				Account acc4=new Account(4,2347,"current",20000);
				 List<Account> acclist = new ArrayList<Account>();
				List<Account> acclist1 = new ArrayList<Account>();
				 acclist.add(acc1);
				acclist.add(acc2);
				acclist1.add(acc3);
				 acclist1.add(acc4);
				 List<Customer> list = new ArrayList<Customer>();
				Customer customer1 =new Customer(1, "RAJ", "banglore","9932043497","123456", acclist);
				 Customer customer2 = new Customer(2, "raju", "kolkata","456123","654321", acclist1);
			     list.add(customer1); 
			     list.add(customer2);
			        init();
			        when(repo.getUserEntityById(1)).thenReturn(customer1);
			         
			        //test
			  
			       Customer name1= service.getCustomerById(1);
				       
			    
			       
			        assertEquals("RAJ", name1.getName());
			}

	       @Test
			void testGetCustomerByName() throws Exception {
				Account acc1=new Account(1,234,"saving",20);
				Account acc2=new Account(2,234,"current",200);
				Account acc3=new Account(3,23456,"saving",20222);
				Account acc4=new Account(4,2347,"current",20000);
				 List<Account> acclist = new ArrayList<Account>();
				List<Account> acclist1 = new ArrayList<Account>();
				 acclist.add(acc1);
				acclist.add(acc2);
				acclist1.add(acc3);
				 acclist1.add(acc4);
				 List<Customer> list = new ArrayList<Customer>();
				Customer customer1 =new Customer(1, "RAJ", "banglore","9932043497","123456", acclist);
				 Customer customer2 = new Customer(2, "raju", "kolkata","456123","654321", acclist1);
			     list.add(customer1); 
			     list.add(customer2);
			        init();
			        when(repo.getUserEntityByName("raju")).thenReturn(list);
			         
			        //test
			  
			        List<Customer> name1= (service.getCustomerByName("raju"));
				       
			    
			       
			        assertEquals("raju", name1.get(1).getName());
			}

	  @Test
		void testGetCustomerByAddress() throws Exception {
			Account acc1=new Account(1,234,"saving",20);
			Account acc2=new Account(2,234,"current",200);
			Account acc3=new Account(3,23456,"saving",20222);
			Account acc4=new Account(4,2347,"current",20000);
			 List<Account> acclist = new ArrayList<Account>();
			List<Account> acclist1 = new ArrayList<Account>();
			 acclist.add(acc1);
			acclist.add(acc2);
			acclist1.add(acc3);
			 acclist1.add(acc4);
			 List<Customer> list = new ArrayList<Customer>();
			Customer customer1 =new Customer(1, "RAJ", "banglore","9932043497","123456", acclist);
			 Customer customer2 = new Customer(2, "raju", "kolkata","456123","654321", acclist1);
		     list.add(customer1); 
		     list.add(customer2);
		        init();
		        when(repo.getUserEntityByAddress("kolkata")).thenReturn(list);
		         
		        //test
		  
		 List<Customer> name1=service.getCustomerByAddress(list.get(1).getAddress());
		       
		        assertEquals("raju", name1.get(1).getName());
		}
	  @Test
			void testGetCustomerByAddharNo() throws Exception {
				Account acc1=new Account(1,234,"saving",20);
				Account acc2=new Account(2,234,"current",200);
				Account acc3=new Account(3,23456,"saving",20222);
				Account acc4=new Account(4,2347,"current",20000);
				 List<Account> acclist = new ArrayList<Account>();
				List<Account> acclist1 = new ArrayList<Account>();
				 acclist.add(acc1);
				acclist.add(acc2);
				acclist1.add(acc3);
				 acclist1.add(acc4);
				 List<Customer> list = new ArrayList<Customer>();
				Customer customer1 =new Customer(1, "RAJ", "banglore","9932043497","123456", acclist);
				 Customer customer2 = new Customer(2, "raju", "kolkata","456123","654321", acclist1);
			     list.add(customer1); 
			     list.add(customer2);
			        init();
			        when(repo.getUserEntityByAddharNo("123456")).thenReturn(list);
			         
			        //test
			  
			        List<Customer> name1= (service.getCustomerByAddharNo("123456"));
			       
			        assertEquals("123456", name1.get(0).getAddharno());
			}
	  @Test
			void testGetCustomerByMobileNo() throws Exception {
				Account acc1=new Account(1,234,"saving",20);
				Account acc2=new Account(2,234,"current",200);
				Account acc3=new Account(3,23456,"saving",20222);
				Account acc4=new Account(4,2347,"current",20000);
				 List<Account> acclist = new ArrayList<Account>();
				List<Account> acclist1 = new ArrayList<Account>();
				 acclist.add(acc1);
				acclist.add(acc2);
				acclist1.add(acc3);
				 acclist1.add(acc4);
				 List<Customer> list = new ArrayList<Customer>();
				Customer customer1 =new Customer(1, "RAJ", "banglore","9932043497","123456", acclist);
				 Customer customer2 = new Customer(2, "raju", "kolkata","456123","654321", acclist1);
			     list.add(customer1); 
			     list.add(customer2);
			        init();
			        when(repo.getUserEntityByMobileNo("9932043497")).thenReturn(list);
			         
			        //test
			  
			        List<Customer> name1= (service.getCustomerByMobileNo("9932043497"));
				       
			        assertEquals("9932043497", name1.get(0).getMobileno());
			       
			        assertEquals("RAJ", name1.get(0).getName());
			}
    	@Test
	void testDeleteAll() throws Exception {
		init();
	
	
		repo.deleteAll();
		
        
        verify(repo, times(1)).deleteAll();
	}

	@Test
	void testCreate() throws Exception {
	
		Account acc1=new Account(1,2345,"saving",20);
		//Account acc2=new Account(234,"current",200);
		//Account acc3=new Account(23456,"saving",20222);
		//Account acc4=new Account(2347,"current",20000);
		 List<Account> acclist = new ArrayList<Account>();
		// List<Account> acclist1 = new ArrayList<Account>();
		 acclist.add(acc1);
		// acclist.add(acc2);
		// acclist1.add(acc3);
		// acclist1.add(acc4);
		
		 Customer customer1 = new Customer(1, "RAJ", "banglore","9932043497","123456", acclist);
		 //Customer customer2 = new Customer(2, "raju", "kolkata","456123","654321", acclist1);
	       
	        
	          
	  
	   init();
	     when(repo.save(customer1)).thenReturn(customer1);
	        //test
	        Customer customer = service.create(customer1);
	       
	        verify(repo, times(1)).save(customer1);
		
		
		 
	}

 
  

	@Test
	void testUpdate() {

		Account acc1=new Account(1,2345,"saving",20);
		//Account acc2=new Account(234,"current",200);
		//Account acc3=new Account(23456,"saving",20222);
		//Account acc4=new Account(2347,"current",20000);
		 List<Account> acclist = new ArrayList<Account>();
		// List<Account> acclist1 = new ArrayList<Account>();
		 acclist.add(acc1);
		// acclist.add(acc2);
		// acclist1.add(acc3);
		// acclist1.add(acc4);
		
		 Customer customer1 = new Customer(1, "RAJ", "banglore","9932043497","123456", acclist);
		 //Customer customer2 = new Customer(2, "raju", "kolkata","456123","654321", acclist1);
	       
	        
	     
	         
	        //test
	   //     int customer = service.update(customer1, 1);
	     //   init();
	       // verify(repo, times(1)).save(customer);
	}
	
	@Test
	void testDeleteCustomer() throws Exception {
		 init();
		 Account acc1=new Account(1,234,"current",200);
			//Account acc2=new Account(234,"current",200);
			//Account acc3=new Account(23456,"saving",20222);
			//Account acc4=new Account(2347,"current",20000);
			 List<Account> acclist = new ArrayList<Account>();
			// List<Account> acclist1 = new ArrayList<Account>();
			 acclist.add(acc1);
			// acclist.add(acc2);
			// acclist1.add(acc3);
			// acclist1.add(acc4);
			
			 Customer customer1 = new Customer(0, "string", "string","string","string", acclist);
			 //Customer customer2 = new Customer(2, "raju", "kolkata","456123","654321", acclist1);
		//repo.getCustomerById(0);

		 verify(repo, times(0)).deleteById(0);
		

	}


}
