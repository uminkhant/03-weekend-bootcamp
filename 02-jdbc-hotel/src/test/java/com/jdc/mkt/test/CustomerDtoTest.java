package com.jdc.mkt.test;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import com.jdc.mkt.service.CustomerService;

public class CustomerDtoTest {
	
	static CustomerService service;
	
	@BeforeAll
	static void init() {
		service = new CustomerService();
	}

	@ParameterizedTest
	@ValueSource(strings = "mintharrkyi")
	void customerCountByHotelName(String name) {
		var list = service.getCustomersWithProcedure(name);
		list.forEach(c -> System.out.println("%.5s\t%d".formatted(c.name(),c.count())));
	}
}
