package com.jdc.mkt.test;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import com.jdc.mkt.AppConfig;
import com.jdc.mkt.repo.CustomerRepo;

@SpringJUnitConfig(classes = AppConfig.class)
public class CustomerTest {

	@Autowired
	CustomerRepo repo;
	
	@Test
	@Disabled
	void findAllByCityName() {
		var list = repo.findAllByCity("Mandalay");
		System.out.println("Size :"+list.size());
		list.forEach(c -> System.out.println( c.getName()));
	}	
	@Test
	@Disabled
	void findAllByCityNameAndTownship() {
		var list = repo.findAllByCityAndTownship("Mandalay","Maharaungmyay");
		System.out.println("Size :"+list.size());
		list.forEach(c -> System.out.println( c.getName()));
	}
	
	//test native query
	@Test
	void findNativeByTownshipId() {
		var customer = repo.findByNativeCustomerTownshipId(1);
		System.out.println(customer.getName());
	}
	
	
	
	
}
