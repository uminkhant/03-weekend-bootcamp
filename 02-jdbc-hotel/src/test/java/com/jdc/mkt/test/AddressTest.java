package com.jdc.mkt.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import com.jdc.mkt.entity.Address;
import com.jdc.mkt.service.AddressService;
import com.jdc.mkt.service.CrudOperation;

@TestMethodOrder(OrderAnnotation.class)
public class AddressTest {

	static CrudOperation<Address> service;
	
	@BeforeAll
	static void init() {
		service = new AddressService();
	}
	
	@Test
	@Order(1)
	void insert() {
		var address = new Address("35st","chanayetharzan","mdy");
		int id = service.insert(address);
		System.out.println("id :"+id);
		//assertEquals(1, row);
	}
	
	//@Test
	@Order(2)
	void update() {
		var address = new Address("22st","chanayetharzan","mdy");
		address.setId(7);
		int row = service.update(address);
		assertEquals(1, row);
	}
	
	//@Test
	@Order(3)
	void delete() {
		var address = new Address();
		address.setActive(false);
		address.setId(7);
		int row = service.delete(address);
		assertEquals(1, row);
	}
	
	//@Test
	@Order(4)
	void select() {
		var address = new Address();
		//address.setStreet("19st,Between 80x81 sts");
		address.setCity("Mandalay");
		address.setTownship("Maharaungmyay");
		var list = service.select(address);
		assertEquals(2, list.size());
	}
}









