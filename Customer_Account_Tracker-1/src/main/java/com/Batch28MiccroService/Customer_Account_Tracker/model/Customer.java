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
import javax.persistence.JoinColumns;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;







@Entity

public class Customer  implements Serializable{
	@Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int  id;
	
	private String name;
	private String address;
	private String mobileno;
	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Customer(int id, String name, String address, String mobileno, String addharno, List<Account> account) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
		this.mobileno = mobileno;
		this.addharno = addharno;
		this.account = account;
	}

	private String addharno;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getMobileno() {
		return mobileno;
	}
	public void setMobileno(String mobileno) {
		this.mobileno = mobileno;
	}
	public String getAddharno() {
		return addharno;
	}
	public void setAddharno(String addharno) {
		this.addharno = addharno;
	}
	public List<Account> getAccount() {
		return account;
	}
	public void setAccount(List<Account> account) {
		this.account = account;
	}
	
	@Override
	public String toString() {
		return "Customer [id=" + id + ", name=" + name + ", address=" + address + ", mobileno=" + mobileno
				+ ", addharno=" + addharno + ", account=" + account + "]";
	}

	@OneToMany(targetEntity=Account.class,cascade=CascadeType.ALL)
	@JoinColumn(name="id_fk",referencedColumnName="id")
	List<Account>account;
	









}
