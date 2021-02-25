package com.Batch28MiccroService.Customer_Account_Tracker.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.Batch28MiccroService.Customer_Account_Tracker.model.Account;
import com.Batch28MiccroService.Customer_Account_Tracker.model.Customer;

public interface AccountRepository extends JpaRepository<Account,Integer > {

	@Query("select a from Account a where a.accountno = :accountno")
	public Account getUserEntityByAccountNo(@Param("accountno") int accountno);

}
