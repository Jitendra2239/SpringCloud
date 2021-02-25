
package com.Batch28MiccroService.Customer_Account_Tracker.repository;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.Batch28MiccroService.Customer_Account_Tracker.model.Account;
import com.Batch28MiccroService.Customer_Account_Tracker.model.Customer;
@ExtendWith(SpringExtension.class)
@DataJpaTest
class AccountRepositoryTest {
	@Autowired
	AccountRepository repo;
	@Test
	void testFindAll() {
		Account acc1=new Account(1,2345,"saving",20);
		Account acc2=new Account(2,234,"current",200);
		Account acc3=new Account(3,23456,"saving",20222);
		Account acc4=new Account(4,2347,"current",20000);
		 List<Account> acclist = new ArrayList<Account>();
	
		 acclist.add(acc1);
		 acclist.add(acc2);
		 acclist.add(acc3);
		 acclist.add(acc4);
		 repo.save(acc1);
		 repo.save(acc2);
		 repo.save(acc3);
		 repo.save(acc4);
			System.out.println(acc1);
		
			 assertThat(acc1.getId()).isNotEqualTo(null);
			
			List<Account> account1 = new ArrayList<Account>(); 
			repo.findAll().forEach(account2->account1.add(account2));
		
			assertEquals(4, account1.size());
	}

	@Test
	void testFindById() {
		 Account acc = new Account();
			Account acc1=new Account(1,2345,"saving",20);
			Account acc2=new Account(2,234,"current",200);
			Account acc3=new Account(3,23456,"saving",20222);
			Account acc4=new Account(4,2347,"current",20000);
			 List<Account> acclist = new ArrayList<Account>();
		
			 acclist.add(acc1);
			 acclist.add(acc2);
			 acclist.add(acc3);
			 acclist.add(acc4);
			 repo.save(acc1);
			 repo.save(acc2);
			 repo.save(acc3);
			 repo.save(acc4);
			
			repo.save(acc1);
			repo.save(acc2);
			repo.save(acc3);
			repo.save(acc4);
		
		
			 assertThat(acc1.getId()).isNotEqualTo(null);
			
		
			 Account  account1=repo.findById(1).get();
			
			assertEquals(2345, acc1.getAccountno());
	}

	@Test
	void testSave() {
		 Account acc = new Account();
			Account acc1=new Account(1,2345,"saving",20);
			Account acc2=new Account(2,234,"current",200);
			Account acc3=new Account(3,23456,"saving",20222);
			Account acc4=new Account(4,2347,"current",20000);
			 List<Account> acclist = new ArrayList<Account>();
		
			 acclist.add(acc1);
			 acclist.add(acc2);
			 acclist.add(acc3);
			 acclist.add(acc4);
			 repo.save(acc1);
			 repo.save(acc2);
			 repo.save(acc3);
			 repo.save(acc4);
			
			repo.save(acc1);
			repo.save(acc2);
			repo.save(acc3);
			repo.save(acc4);
			
		
			System.out.println(acc1);
			
			 assertThat(acc1.getId()).isNotEqualTo(null);
			
			List<Account> account1 = new ArrayList<Account>(); 
			repo.findAll().forEach(account2->account1.add(account2));
		
			assertEquals(4, account1.size());
	}

}
