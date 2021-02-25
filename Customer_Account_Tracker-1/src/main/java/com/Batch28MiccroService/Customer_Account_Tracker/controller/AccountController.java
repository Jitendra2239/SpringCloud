package com.Batch28MiccroService.Customer_Account_Tracker.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.Batch28MiccroService.Customer_Account_Tracker.exception.ExceptionResponse;
import com.Batch28MiccroService.Customer_Account_Tracker.model.Account;
import com.Batch28MiccroService.Customer_Account_Tracker.model.Customer;
import com.Batch28MiccroService.Customer_Account_Tracker.service.AccountService;
import com.Batch28MiccroService.Customer_Account_Tracker.service.CustomerService;

@Validated
@RestController
public class AccountController {
	
	@Autowired
	 AccountService service;
	
	@GetMapping("/accounts")
	public  ResponseEntity<List<Account>>getAllAccounts() throws Exception{
	 List<Account>customer= service.getAllAccount();
	
	 return new ResponseEntity<List<Account>>(customer,HttpStatus.FOUND);
		}
	@GetMapping("/accountsfunds")
	public ResponseEntity<String>fundTransfer(@RequestParam int accountno1,@RequestParam int accountno2,@RequestParam int amount){
		
		Account acc1=service.getAccountByAccountNo(accountno1);
	      Account acc2=service.getAccountByAccountNo(accountno2);
		
	    int res1=acc1.getAmount();
	    int res2=acc2.getAmount();
	    int res=res1-amount;
	    if(res>=0) {
	    	
	    acc1.setAmount(res);
	    acc2.setAmount(res2+amount);
	    service.update(acc1);
	    service.update(acc2);
	   	 return new ResponseEntity<String>("Fund Transfer Done!",HttpStatus.OK);
	  
	    }
  	    return new ResponseEntity<String>(HttpStatus.NOT_FOUND);
	}

}
