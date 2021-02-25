package com.Batch28MiccroService.Customer_Account_Tracker.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.Batch28MiccroService.Customer_Account_Tracker.dto.CustomerResponse;
import com.Batch28MiccroService.Customer_Account_Tracker.model.Customer;
import com.google.common.base.Optional;
@Repository
public interface CustomerRepository extends JpaRepository<Customer,Integer > {

	@Query("select c from Customer c where c.id = :id")
	public Customer getUserEntityById(@Param("id") int id);
	@Query("select c from Customer c where c.name = :name")
	public List<Customer> getUserEntityByName(@Param("name") String name);
	
	@Query("select c from Customer c where c.address = :address")
	public List<Customer> getUserEntityByAddress(@Param("address") String address);
	@Query("select c from Customer c where c.mobileno = :mobileno")
	public List<Customer> getUserEntityByMobileNo(@Param("mobileno") String mobileno);
	@Query("select c from Customer c where c.addharno = :addharno")
	public List<Customer> getUserEntityByAddharNo(@Param("addharno") String addharno);

	
	
}
