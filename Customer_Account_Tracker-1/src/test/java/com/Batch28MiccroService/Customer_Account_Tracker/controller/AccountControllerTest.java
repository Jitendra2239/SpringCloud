package com.Batch28MiccroService.Customer_Account_Tracker.controller;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.Batch28MiccroService.Customer_Account_Tracker.model.Account;
import com.Batch28MiccroService.Customer_Account_Tracker.model.Customer;
import com.Batch28MiccroService.Customer_Account_Tracker.service.AccountService;
import com.Batch28MiccroService.Customer_Account_Tracker.service.CustomerService;
@ExtendWith(SpringExtension.class)
@WebMvcTest(AccountController.class)
//@WebMvcTest
class AccountControllerTest {

	
	@Autowired
	MockMvc mockmvc;
	
	@MockBean
	private AccountService service;	
	@Test
	void testGetAllAccounts() throws Exception {
	
			Account acc1=new Account(1,2345,"saving",20);
			
			 List<Account> acclist = new ArrayList<Account>();
		
			 acclist.add(acc1);
		
		
		     
		    
		        when(service.getAllAccount()).thenReturn(acclist);
		        RequestBuilder request=MockMvcRequestBuilders.get("/accounts").accept(MediaType.APPLICATION_JSON);
			     mockmvc.perform(request)
			      .andExpect(status().isFound())
			      .andExpect(MockMvcResultMatchers.jsonPath("$").exists())
			      .andExpect(MockMvcResultMatchers.jsonPath("$[*].id").isNotEmpty());
		  
		
		
	}

	@Test
	void testFundTransfer() throws Exception {
		Account acc1=new Account(1,2345,"saving",20);
		Account acc2=new Account(2,2346,"saving",10);
		 when(service.getAccountByAccountNo(2345)).thenReturn(acc1);
		 when(service.getAccountByAccountNo(2346)).thenReturn(acc2);
		  int res1=acc1.getAmount();
		    int res2=acc2.getAmount();
		    int res=res1-5;
		    acc1.setAmount(res);
		    acc2.setAmount(res2+5);
			when(service.update(acc1)).thenReturn(acc1);
			 when(service.update(acc2)).thenReturn(acc2);
			   RequestBuilder request=MockMvcRequestBuilders.get("/accountsfunds").accept(MediaType.APPLICATION_JSON);
			     mockmvc.perform(request)
			      .andExpect(status().isNotFound())
			      .andExpect(MockMvcResultMatchers.jsonPath("$").exists())
			      .andExpect(MockMvcResultMatchers.jsonPath("$[*].accountno").isEmpty());
	}

}
