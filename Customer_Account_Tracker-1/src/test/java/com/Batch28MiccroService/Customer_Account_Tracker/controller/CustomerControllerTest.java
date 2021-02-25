package com.Batch28MiccroService.Customer_Account_Tracker.controller;


import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.Batch28MiccroService.Customer_Account_Tracker.dto.CreateCustomer;
import com.Batch28MiccroService.Customer_Account_Tracker.model.Account;
import com.Batch28MiccroService.Customer_Account_Tracker.model.Customer;
import com.Batch28MiccroService.Customer_Account_Tracker.service.CustomerService;
import com.fasterxml.jackson.databind.ObjectMapper;


@ExtendWith(SpringExtension.class)
@WebMvcTest(CustomerController.class)
class CustomerControllerTest {
	@Autowired
	MockMvc mockmvc;
	
	@MockBean
	private CustomerService service;	
	public static String asJsonString(final Object obj) {
	    try {
	        return new ObjectMapper().writeValueAsString(obj);
	    } catch (Exception e) {
	        throw new RuntimeException(e);
	    }
	}

 	@Test
	void testGetAllCustomers() throws Exception {
		Account acc1=new Account(1,2345,"saving",20);
		
		 List<Account> acclist = new ArrayList<Account>();
	
		 acclist.add(acc1);
	
		 List<Customer> list = new ArrayList<Customer>();
		 Customer customer1 = new Customer(1, "RAJ", "banglore","9932043497","123456", acclist);
		
	        list.add(customer1);
	     
	    
	        when(service.getAllCustomer()).thenReturn(list);
	        RequestBuilder request=MockMvcRequestBuilders.get("/customers").accept(MediaType.APPLICATION_JSON);
		     mockmvc.perform(request)
		      .andExpect(status().isFound())
		      .andExpect(MockMvcResultMatchers.jsonPath("$").exists())
		      .andExpect(MockMvcResultMatchers.jsonPath("$[*].id").isNotEmpty());
	  
	
	}


	// * "account":[{"accountno":2345,"accounttype":"saving","amount":20}]
		@Test
	void testGetCustomerById() throws Exception {
		Account acc1=new Account(1,2345,"saving",20);
		//Account acc2=new Account(234,"current",200);
		//Account acc3=new Account(23456,"saving",20222);
		//Account acc4=new Account(2347,"current",20000);
		 List<Account> acclist = new ArrayList<Account>();
		//List<Account> acclist1 = new ArrayList<Account>();
		 acclist.add(acc1);
		//acclist.add(acc2);
	   //acclist1.add(acc3);
	 //acclist1.add(acc4);
		
		 Customer customer1 = new Customer(1, "RAJ", "banglore","9932043497","123456", acclist);
		// Customer customer2 = new Customer(2, "raju", "kolkata","456123","654321", acclist1);
		 when(service.getCustomerById(1)).thenReturn(customer1);
		 RequestBuilder request=MockMvcRequestBuilders.get("/customer/{id}",1).accept(MediaType.APPLICATION_JSON);
	     mockmvc.perform(request)
			.andExpect(status().isFound())
			 .andExpect(MockMvcResultMatchers.jsonPath("$.name").value("RAJ"));
	}
	
		@Test
		void testGetCustomerByName() throws Exception {
			Account acc1=new Account(1,2345,"saving",20);
			//Account acc2=new Account(234,"current",200);
			//Account acc3=new Account(23456,"saving",20222);
			//Account acc4=new Account(2347,"current",20000);
			 List<Account> acclist = new ArrayList<Account>();
			//List<Account> acclist1 = new ArrayList<Account>();
			 acclist.add(acc1);
			//acclist.add(acc2);
		   //acclist1.add(acc3);
		 //acclist1.add(acc4);
			
			 Customer customer1 = new Customer(1, "RAJ", "banglore","9932043497","123456", acclist);
			// Customer customer2 = new Customer(2, "raju", "kolkata","456123","654321", acclist1);
			 List<Customer> list = new ArrayList<Customer>();
			 list.add(customer1);
			 when(service.getCustomerByName("RAJ")).thenReturn(list);
			 RequestBuilder request=MockMvcRequestBuilders.get("/customername/{name}","RAJ").accept(MediaType.APPLICATION_JSON);
		     mockmvc.perform(request)
				.andExpect(status().isFound());
				 //.andExpect(MockMvcResultMatchers.jsonPath("$.name").value("RAJ"));
		}
		
		@Test
		void testGetCustomerByAddress() throws Exception {
			Account acc1=new Account(1,2345,"saving",20);
			//Account acc2=new Account(234,"current",200);
			//Account acc3=new Account(23456,"saving",20222);
			//Account acc4=new Account(2347,"current",20000);
			 List<Account> acclist = new ArrayList<Account>();
			//List<Account> acclist1 = new ArrayList<Account>();
			 acclist.add(acc1);
			//acclist.add(acc2);
		   //acclist1.add(acc3);
		 //acclist1.add(acc4);
			
			 Customer customer1 = new Customer(1, "RAJ", "banglore","9932043497","123456", acclist);
			// Customer customer2 = new Customer(2, "raju", "kolkata","456123","654321", acclist1);
		
			 List<Customer> list = new ArrayList<Customer>();
			 list.add(customer1);
			 when(service.getCustomerByAddress("banglore")).thenReturn(list);
			 RequestBuilder request=MockMvcRequestBuilders.get("/customeraddress/{address}","banglore").accept(MediaType.APPLICATION_JSON);
		     mockmvc.perform(request)
				.andExpect(status().isFound());
				// .andExpect(MockMvcResultMatchers.jsonPath("$.name").value("banglore", list));
		}
		
		
		@Test
		void testGetCustomerByAddharNo() throws Exception {
			Account acc1=new Account(1,2345,"saving",20);
			//Account acc2=new Account(234,"current",200);
			//Account acc3=new Account(23456,"saving",20222);
			//Account acc4=new Account(2347,"current",20000);
			 List<Account> acclist = new ArrayList<Account>();
			//List<Account> acclist1 = new ArrayList<Account>();
			 acclist.add(acc1);
			//acclist.add(acc2);
		   //acclist1.add(acc3);
		 //acclist1.add(acc4);
			
			 Customer customer1 = new Customer(1, "RAJ", "banglore","9932043497","123456", acclist);
			// Customer customer2 = new Customer(2, "raju", "kolkata","456123","654321", acclist1);
			 List<Customer> list = new ArrayList<Customer>();
			 list.add(customer1);
			 when(service.getCustomerByAddharNo("123456")).thenReturn(list);
			 RequestBuilder request=MockMvcRequestBuilders.get("/customeraddharno/{addharno}","123456").accept(MediaType.APPLICATION_JSON);
		     mockmvc.perform(request)
				.andExpect(status().isFound());
				 //.andExpect(MockMvcResultMatchers.jsonPath("$.address").value("banglore"));
		}
		@Test
		void testGetCustomerByMobileNo() throws Exception {
			Account acc1=new Account(1,2345,"saving",20);
			//Account acc2=new Account(234,"current",200);
			//Account acc3=new Account(23456,"saving",20222);
			//Account acc4=new Account(2347,"current",20000);
			 List<Account> acclist = new ArrayList<Account>();
			//List<Account> acclist1 = new ArrayList<Account>();
			 acclist.add(acc1);
			//acclist.add(acc2);
		   //acclist1.add(acc3);
		 //acclist1.add(acc4);
			
			 Customer customer1 = new Customer(1, "RAJ", "banglore","9932043497","123456", acclist);
			// Customer customer2 = new Customer(2, "raju", "kolkata","456123","654321", acclist1);
			 List<Customer> list = new ArrayList<Customer>();
			 list.add(customer1);
			 when(service.getCustomerByMobileNo("9932043497")).thenReturn(list);
			 RequestBuilder request=MockMvcRequestBuilders.get("/customermobileno/{MobileNo}","9932043497").accept(MediaType.APPLICATION_JSON);
		     mockmvc.perform(request)
				.andExpect(status().isFound());
				// .andExpect(MockMvcResultMatchers.jsonPath("$.address").value("banglore"));
		}
		@Test
	void testCreateCustomer() throws Exception {
		Account acc1=new Account(1,2345,"saving",20);
	
		 List<Account> acclist = new ArrayList<Account>();
	
		 acclist.add(acc1);
	
		// List<Customer> list = new ArrayList<Customer>();
		 Customer customer1 = new Customer(1, "RAJ", "banglore","9932043497","123456", acclist);
		 mockmvc.perform( MockMvcRequestBuilders
		  .post("/customer")
      .content(asJsonString(customer1))
      .contentType(MediaType.APPLICATION_JSON)
      .accept(MediaType.APPLICATION_JSON))
      .andExpect(status().isCreated());
      
	}

	@Test
	void testUpdate() throws Exception {
	
		Account acc1=new Account(1,2345,"saving",20);
		
		 List<Account> acclist = new ArrayList<Account>();
	
		 acclist.add(acc1);
	
		// List<Customer> list = new ArrayList<Customer>();
		 Customer customer1 = new Customer(1, "RAJ", "banglore","9932043497","123456", acclist);
		
		mockmvc.perform( MockMvcRequestBuilders
     .put("/customer",1)
     .content(asJsonString(customer1))
     .contentType(MediaType.APPLICATION_JSON)
   
     .accept(MediaType.APPLICATION_JSON))
     .andExpect(status().isCreated());
   //  .andExpect(MockMvcResultMatchers.jsonPath("$.name").value("RAJ"));
	}
	@Test
	void testDeleteCustomer() throws Exception {
		mockmvc.perform( MockMvcRequestBuilders.delete("/delete/{id}",1))
	        .andExpect(status().isAccepted());
	}
	
	@Test
	void testDeleteCustomerAll() throws Exception {
		mockmvc.perform( MockMvcRequestBuilders.delete("/deleteall") )
        .andExpect(status().isAccepted());
	
	}	

	@Test
	void testWelcome() throws Exception {
		RequestBuilder request=MockMvcRequestBuilders.get("/").accept(MediaType.APPLICATION_JSON);
		MvcResult mvcresult=mockmvc.perform(request).andReturn();
		
	   assertEquals("Welcome to Batch28 MicroService",mvcresult.getResponse().getContentAsString());
	}

}
