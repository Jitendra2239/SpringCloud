package com.Batch28MiccroService.Customer_Account_Tracker.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;

import com.Batch28MiccroService.Customer_Account_Tracker.model.Account;
import com.Batch28MiccroService.Customer_Account_Tracker.model.Customer;
import com.Batch28MiccroService.Customer_Account_Tracker.repository.AccountRepository;
import com.Batch28MiccroService.Customer_Account_Tracker.repository.CustomerRepository;
@RunWith(MockitoJUnitRunner.class)
class AccountServiceTest {
	@Mock
	AccountRepository repo;
	@InjectMocks
   AccountService service;
	@Autowired
	CustomerRepository repo1;
	@Before
	public void init()throws Exception
	{
		MockitoAnnotations.initMocks(this);
	}

	@Test
	void testGetAllAccount() throws Exception {
		Account acc1=new Account(1,2345,"saving",20);
		Account acc2=new Account(2,234,"current",200);
		Account acc3=new Account(3,23456,"saving",20222);
		Account acc4=new Account(4,2347,"current",20000);
		 List<Account> acclist = new ArrayList<Account>();
	
		 acclist.add(acc1);
		 acclist.add(acc2);
		 acclist.add(acc3);
		 acclist.add(acc4);
		
		 System.out.println(acclist);
			
		 assertThat(acc1.getId()).isNotEqualTo(null);
		
	
		 Account account1=repo.findById(1).get();
		//System.out.println(customer1);
		assertEquals(20, account1.getAmount());
	}

	@Test
	void testGetAccountById() throws Exception {
		Account acc1=new Account(1,234,"saving",20);
		//Account acc2=new Account(234,"current",200);
		//Account acc3=new Account(23456,"saving",20222);
		//Account acc4=new Account(2347,"current",20000);
		 List<Account> acclist = new ArrayList<Account>();
		// List<Account> acclist1 = new ArrayList<Account>();
		 acclist.add(acc1);
		// acclist.add(acc2);
		// acclist1.add(acc3);
		// acclist1.add(acc4);
		 
	
	        init();
	        when(repo.getUserEntityByAccountNo(234)).thenReturn(acc1);
	         
	        //test
	        int id1 = service.getAccountByAccountNo(234).getAmount();
	       
	        assertEquals(20, id1);
	}

	@Test
	void testUpdate() throws Exception {
		Account acc1=new Account(1,2345,"saving",20);
		//Account acc2=new Account(234,"current",200);
		//Account acc3=new Account(23456,"saving",20222);
		//Account acc4=new Account(2347,"current",20000);
		 List<Account> acclist = new ArrayList<Account>();
		
		 acclist.add(acc1);
		// acclist.add(acc2);
		// acclist1.add(acc3);
		// acclist1.add(acc4);
		
		
	       
	        
		  init();
	         
		 when(repo.save(acc1)).thenReturn(acc1);
	   Account acc = service.update(acc1);
	   
	     
	       verify(repo, times(1)).save(acc1);
	}

}
