package com.wipro.cruddemo.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Employee implements Serializable{
	@Id
	@Column
private int empid;
	@Column
private String empname;
	@Column
private String empband;
	@Column
private int empsal;

public int getEmpid() {
	return empid;
}
public void setEmpid(int empid) {
	this.empid = empid;
}
public String getEmpname() {
	return empname;
}
public void setEmpname(String empname) {
	this.empname = empname;
}
public String getEmpband() {
	return empband;
}
public void setEmpband(String empband) {
	this.empband = empband;
}
public int getEmpsal() {
	return empsal;
}
public void setEmpsal(int empsal) {
	this.empsal = empsal;
}
public Employee(int empid, String empname, String empband, int empsal) {
	super();
	this.empid = empid;
	this.empname = empname;
	this.empband = empband;
	this.empsal = empsal;
}
public Employee() {
	super();
}

}
