package com.Batch28MiccroService.Customer_Account_Tracker.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table
public class Account implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private int accountno;
	private String accounttype;
	private int amount;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getAccountno() {
		return accountno;
	}
	public void setAccountno(int accountno) {
		this.accountno = accountno;
	}
	public String getAccounttype() {
		return accounttype;
	}
	public void setAccounttype(String accounttype) {
		this.accounttype = accounttype;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public Account(int id,int accountno, String accounttype, int amount) {
		super();
		this.id=id;
		this.accountno = accountno;
		this.accounttype = accounttype;
		this.amount = amount;
	}
	@Override
	public String toString() {
		return "Account [accountno=" + accountno + ", accounttype=" + accounttype + ", amount=" + amount + "]";
	}
	public Account() {
		super();
		// TODO Auto-generated constructor stub
	}
	



		
   
}
