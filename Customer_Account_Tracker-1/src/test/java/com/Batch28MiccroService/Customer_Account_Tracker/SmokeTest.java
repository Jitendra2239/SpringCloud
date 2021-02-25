package com.Batch28MiccroService.Customer_Account_Tracker;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.Batch28MiccroService.Customer_Account_Tracker.controller.CustomerController;

@SpringBootTest
public class SmokeTest {

	@Autowired
	private CustomerController controller;

	@Test
	public void contextLoads() throws Exception {
		assertThat(controller).isNotNull();
	}
}
