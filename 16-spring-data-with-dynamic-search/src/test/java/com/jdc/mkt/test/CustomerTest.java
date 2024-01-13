package com.jdc.mkt.test;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import com.jdc.mkt.AppConfig;
import com.jdc.mkt.service.CustomerService;

@SpringJUnitConfig(classes = AppConfig.class)
public class CustomerTest {

	@Autowired
	CustomerService service;
	
	@ParameterizedTest
	@CsvSource({
		"Andrew,,,",
		"Sophia,'No.3, 56th Street Quarter (7)',,",
		",,Hlaing,",
		",,,Yangon"
		})
	void search(String name,String street,String township,String city) {
		var list = service.search(name, street, township, city);
		list.forEach(c -> System.out.println(
				c.getName()+"\t"+
			    c.getAddress().getStreet()+"\t"+
			    c.getAddress().getTownship()+"\t"+
			    c.getAddress().getCity()
				));
		System.out.println("=====================================");
	}
}
