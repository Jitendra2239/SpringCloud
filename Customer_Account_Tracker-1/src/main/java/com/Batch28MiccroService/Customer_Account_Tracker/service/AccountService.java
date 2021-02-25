package com.Batch28MiccroService.Customer_Account_Tracker.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Batch28MiccroService.Customer_Account_Tracker.model.Account;
import com.Batch28MiccroService.Customer_Account_Tracker.model.Customer;
import com.Batch28MiccroService.Customer_Account_Tracker.repository.AccountRepository;

@Service
public class AccountService {

	@Autowired
	 AccountRepository  repo1;
	
	public List<Account>getAllAccount(){
		List<Account> account = new ArrayList<Account>(); 
		repo1.findAll().forEach(account1 ->account.add(account1));  

		return account;  
	}
	public Account getAccountById(int id)   
	{  
	return repo1.findById(id).get();
	} 
	public Account getAccountByAccountNo(int accountno)   
	{  
	return repo1.getUserEntityByAccountNo(accountno);
	} 
	public Account update(Account acc)   
	{  
	return repo1.save(acc);
	} 
}
