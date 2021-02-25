package com.Batch28MiccroService.Customer_Account_Tracker.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.Batch28MiccroService.Customer_Account_Tracker.dto.CreateCustomer;
import com.Batch28MiccroService.Customer_Account_Tracker.dto.CustomerResponse;
import com.Batch28MiccroService.Customer_Account_Tracker.exception.UserNotFoundException;
import com.Batch28MiccroService.Customer_Account_Tracker.model.Account;
import com.Batch28MiccroService.Customer_Account_Tracker.model.Customer;
import com.Batch28MiccroService.Customer_Account_Tracker.repository.CustomerRepository;
import com.Batch28MiccroService.Customer_Account_Tracker.service.CustomerService;
import com.google.common.base.Optional;

@RestController
public class CustomerController{

	@Autowired
	 CustomerService service;

	@GetMapping("/customers")
	public  ResponseEntity<List<Customer>>getAllCustomers() {
	 List<Customer>customer= service.getAllCustomer();
	 if(customer.size()==0)
	 return new ResponseEntity<List<Customer>>(HttpStatus.NOT_FOUND);
	 return new ResponseEntity<List<Customer>>(customer,HttpStatus.FOUND);
		}
@GetMapping("/customer/{id}")
	public  ResponseEntity<Object>getAllCustomersById(@PathVariable("id") int id) {

	     Customer customer=service.getCustomerById(id);

	 return new ResponseEntity<Object>(customer,HttpStatus.FOUND);
	}
	@GetMapping("/customername/{name}")
	public  ResponseEntity<List<Customer>>getAllCustomersByName(@PathVariable("name") String name) {

		List<Customer>customer=service.getCustomerByName( name);

	 return new ResponseEntity<List<Customer>>(customer,HttpStatus.FOUND);
	}
	@GetMapping("/customeraddress/{address}")
	public  ResponseEntity<List<Customer>> getAllCustomersByAddress(@PathVariable("address") String address) {

		List<Customer>customer=service.getCustomerByAddress(address);

	 return new ResponseEntity<List<Customer>>(customer,HttpStatus.FOUND);
	}
	
	
	@GetMapping("/customeraddharno/{addharno}")
	public  ResponseEntity<List<Customer>> getAllCustomersByAddharNo(@PathVariable("addharno") String addharno)
	{
		List<Customer>customer=service.getCustomerByAddharNo(addharno);

		 return new ResponseEntity<List<Customer>>(customer,HttpStatus.FOUND);
	}
	
	@GetMapping("/customermobileno/{mobileno}")
	public  ResponseEntity<List<Customer>> getAllCustomersByMobileNo(@PathVariable("mobileno") String mobileno)
	{
		List<Customer>customer=service.getCustomerByMobileNo(mobileno);

		 return new ResponseEntity<List<Customer>>(customer,HttpStatus.FOUND);
	}
	
	@PostMapping("/customer")  
	public ResponseEntity<Customer> createCustomer( @RequestBody CreateCustomer customer)throws Exception {
	
		Customer customer1=customer.getCustomer();
		Customer customer2=	service.create(customer1);
	 
	    return new ResponseEntity<Customer>(customer1,HttpStatus.CREATED);
	}
	
	@PutMapping("/customer")  
	public ResponseEntity<Customer>  update(@RequestBody CreateCustomer customer)   
	{  
		Customer customer1=customer.getCustomer();
		Customer customer2=	service.update(customer1, customer1.getId());
	
	 return new ResponseEntity<Customer>(customer2,HttpStatus.CREATED);
	}
	@DeleteMapping(value = "/delete/{id}")
	public ResponseEntity<HttpStatus> deleteCustomer(@PathVariable("id") int id)throws Exception
	  {
	            service.deleteCustomer(id);
	
		  return new ResponseEntity<HttpStatus>(HttpStatus.ACCEPTED);
		
	  }
	 
	 @DeleteMapping("/deleteall")
	
	public   ResponseEntity<String>deleteCustomerAll()throws Exception
	  {
		int res=service.deleteAll();
	
	     return new ResponseEntity<String>("All Customer Deleted",HttpStatus.ACCEPTED);
	  }

	 @GetMapping("/")
	public   String welcome()
	  {
		 return "Welcome to Batch28 MicroService" ;
	  }
	 
	}

