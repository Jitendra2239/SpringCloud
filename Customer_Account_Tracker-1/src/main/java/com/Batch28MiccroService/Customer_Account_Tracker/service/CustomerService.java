package com.Batch28MiccroService.Customer_Account_Tracker.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.Batch28MiccroService.Customer_Account_Tracker.dto.CreateCustomer;
import com.Batch28MiccroService.Customer_Account_Tracker.model.Account;
import com.Batch28MiccroService.Customer_Account_Tracker.model.Customer;
import com.Batch28MiccroService.Customer_Account_Tracker.repository.AccountRepository;
import com.Batch28MiccroService.Customer_Account_Tracker.repository.CustomerRepository;
import com.google.common.base.Optional;
@Transactional
@Service
public class CustomerService {
	@Autowired
	CustomerRepository repo;
	@Autowired
	 AccountRepository  repo1;


public Customer create(Customer customer)
{  
return  repo.save(customer);
}
public List<Customer>getAllCustomer(){
	List<Customer> customer = new ArrayList<Customer>(); 
	repo.findAll().forEach(customer1 ->customer.add(customer1));  

	return customer;  
}
public Customer getCustomerById(int id)   
{  
return repo.getUserEntityById(id);
} 
 
public List<Customer> getCustomerByName(String name)   
{  
return repo.getUserEntityByName(name);
} 
public List<Customer> getCustomerByAddress(String address)   
{  
return repo.getUserEntityByAddress(address);
} 
public List<Customer> getCustomerByMobileNo(String mobileno)   
{  
return repo.getUserEntityByMobileNo(mobileno);
}
public List<Customer> getCustomerByAddharNo(String addharno)   
{  
return repo.getUserEntityByAddharNo(addharno);
}
public Customer update(Customer customer,int customerid){

	Customer cus= repo.save(customer);
	return cus;
}
public int deleteAll() {
	
 int count=0;
 for(Customer element:repo.findAll()) {
    repo.delete((element));
	count++;
 }
 return count;
}

public void deleteCustomer(int id) {
	repo.deleteById(id);
	// int count=0;
	// for(Customer element:repo.findAll()) {
	//   if( element.getId()==id)
	    //	repo.deleteById(element.getId());
	 //  return element;
	// }
	// Customer customer = null;
    // return customer;
}
}