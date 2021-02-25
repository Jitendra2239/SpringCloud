package com.Batch28MiccroService.Customer_Account_Tracker.dto;

import com.Batch28MiccroService.Customer_Account_Tracker.model.Account;
import com.Batch28MiccroService.Customer_Account_Tracker.model.Customer;

public class CreateCustomer{
	private Customer customer;
	private Account account;
	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
	
	     
		this.customer = customer;
	}

	

}
