package com.Batch28MiccroService.Customer_Account_Tracker.dto;

public class CustomerResponse {

	
	private  String name;
	private  int accountno;
	private  int amount;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAccountno() {
		return accountno;
	}
	public void setAccountno(int accountno) {
		this.accountno = accountno;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
}
