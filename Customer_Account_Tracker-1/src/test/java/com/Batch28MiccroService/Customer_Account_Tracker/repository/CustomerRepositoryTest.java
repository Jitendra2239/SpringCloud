package com.Batch28MiccroService.Customer_Account_Tracker.repository;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;

import com.Batch28MiccroService.Customer_Account_Tracker.model.Account;
import com.Batch28MiccroService.Customer_Account_Tracker.model.Customer;

@RunWith(SpringRunner.class)
@DataJpaTest

class CustomerRepositoryTest {

	@Autowired
	CustomerRepository repo;
	

	@Test
	void testGetUserEntityByName() {
		 Account acc = new Account();
			acc.setAccountno(100);
			acc.setAccounttype("saving");
			acc.setAmount(500);
			List<Account>acclist=new ArrayList<Account>();
			Customer customer=new Customer(1,"Jitendra","Bihar","9932043497","8969168497",acclist);
		//	List<Customer>list=new ArrayList<Customer>();
		//	list.add(customer);
			List<Customer>list=	repo.getUserEntityByName("Jitendrar");
			System.out.println(customer);
		
			 assertThat(customer.getId()).isNotEqualTo(null);
			
		
			 Customer  customer1=repo.findById(1).get();
			System.out.println(customer1);
			assertEquals("Jitendra", customer1.getName());
	}

	@Test
	void testGetUserEntityByAddress() {
		 Account acc = new Account();
			acc.setAccountno(100);
			acc.setAccounttype("saving");
			acc.setAmount(500);
			List<Account>acclist=new ArrayList<Account>();
			Customer customer=new Customer(1,"Jitendra","Bihar","9932043497","8969168497",acclist);
		//	List<Customer>list=new ArrayList<Customer>();
		//	list.add(customer);
			List<Customer>list=	repo.getUserEntityByAddress("Bihar");
			System.out.println(customer);
		
			 assertThat(customer.getId()).isNotEqualTo(null);
			
		
			 Customer  customer1=repo.findById(1).get();
			System.out.println(customer1);
			assertEquals("Jitendra", customer1.getName());
	}

	@Test
	void testGetUserEntityByMobileNo() {
		 Account acc = new Account();
			acc.setAccountno(100);
			acc.setAccounttype("saving");
			acc.setAmount(500);
			List<Account>acclist=new ArrayList<Account>();
			Customer customer=new Customer(1,"Jitendra","Bihar","9932043497","8969168497",acclist);
		//	List<Customer>list=new ArrayList<Customer>();
		//	list.add(customer);
			List<Customer>list=	repo.getUserEntityByMobileNo("9932043497");
			System.out.println(customer);
		
			 assertThat(customer.getId()).isNotEqualTo(null);
			
		
			 Customer  customer1=repo.findById(1).get();
			System.out.println(customer1);
			assertEquals("Jitendra", customer1.getName());
	}

	@Test
	void testGetUserEntityByAddharNo() {
		 Account acc = new Account();
			acc.setAccountno(100);
			acc.setAccounttype("saving");
			acc.setAmount(500);
			List<Account>acclist=new ArrayList<Account>();
			Customer customer=new Customer(1,"Jitendra","Bihar","9932043497","8969168497",acclist);
		//	List<Customer>list=new ArrayList<Customer>();
		//	list.add(customer);
			List<Customer>list=	repo.getUserEntityByAddharNo("8969168497");
			System.out.println(customer);
		
			 assertThat(customer.getId()).isNotEqualTo(null);
			
		
			 Customer  customer1=repo.findById(1).get();
			System.out.println(customer1);
			assertEquals("Jitendra", customer1.getName());
	}


	@Test
	void testSave() {
	    Account acc = new Account();
		acc.setAccountno(100);
		acc.setAccounttype("saving");
		acc.setAmount(500);
		List<Account>acclist=new ArrayList<Account>();
		Customer customer=new Customer(1,"Jitendra","Bihar","9932043497","8969168497",acclist);
		
		repo.save(customer);
		System.out.println(customer);
	
		 assertThat(customer.getId()).isNotEqualTo(null);
		
		List<Customer> customer1 = new ArrayList<Customer>(); 
		repo.findAll().forEach(customer2->customer1.add(customer2));
		System.out.println(customer1);
		assertEquals(1, customer1.size());
	}

	@Test
	void testFindById() {
	    Account acc = new Account();
			acc.setAccountno(100);
			acc.setAccounttype("saving");
			acc.setAmount(500);
			List<Account>acclist=new ArrayList<Account>();
			Customer customer=new Customer(1,"Jitendra","Bihar","9932043497","8969168497",acclist);
			
			repo.save(customer);
			System.out.println(customer);
		
			 assertThat(customer.getId()).isNotEqualTo(null);
			
		
			 Customer  customer1=repo.findById(1).get();
			System.out.println(customer1);
			assertEquals("Jitendra", customer1.getName());
	}

	@Test
	void testDeleteById() {
		 Account acc = new Account();
			acc.setAccountno(100);
			acc.setAccounttype("saving");
			acc.setAmount(500);
			List<Account>acclist=new ArrayList<Account>();
			Customer customer=new Customer(2,"Jitendra","Bihar","9932043497","8969168497",acclist);
			
			repo.save(customer);
			System.out.println(customer);
		
			 assertThat(customer.getId()).isNotEqualTo(null);
			
		
			 repo.deleteById(2);
			
			 verify(repo, times(1)).deleteById(2);
	}

	@Test
	void testDeleteAll() {
		 Account acc = new Account();
			acc.setAccountno(100);
			acc.setAccounttype("saving");
			acc.setAmount(500);
			List<Account>acclist=new ArrayList<Account>();
			Customer customer=new Customer(2,"Jitendra","Bihar","9932043497","8969168497",acclist);
			
			repo.save(customer);
			System.out.println(customer);
		
			 assertThat(customer.getId()).isNotEqualTo(null);
			
		
			 repo.deleteAll();
			
			 verify(repo, times(1)).deleteAll();
	}

}
