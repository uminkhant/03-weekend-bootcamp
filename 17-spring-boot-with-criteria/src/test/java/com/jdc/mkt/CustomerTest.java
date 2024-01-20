package com.jdc.mkt;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.jdc.mkt.service.CustomerService;

@SpringBootTest
public class CustomerTest {

	@Autowired
	CustomerService service;
	
	@Test
	void testFindCustomerByNameAndEmail() {
		var list = service.findCustomerByNameAndEmail("Sophia", "sopha@gmail.com");
		System.out.println(list);
	}
	@Test
	@Disabled
	void testFindCustomerByCity() {
		var list = service.findCustomerByCity("Mandalay");
		System.out.println(list);
	}
	
	
}
