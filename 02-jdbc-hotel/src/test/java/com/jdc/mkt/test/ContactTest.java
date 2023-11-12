package com.jdc.mkt.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import com.jdc.mkt.entity.Contact;
import com.jdc.mkt.service.ContactService;
import com.jdc.mkt.service.CrudOperation;

@TestMethodOrder(OrderAnnotation.class)
public class ContactTest {

	static CrudOperation<Contact> service;
	
	@BeforeAll
	static void init() {
		service = new ContactService();
	}
	
	@Test
	@Order(1)
	void insert() {
		var contact = new Contact("09636633","099992342","test@gmail.com");
		int row = service.insert(contact);
		assertEquals(1, row);
	}
	
	@Test
	@Order(2)
	void update() {
		var contact = new Contact("096222223","099332342","testupdate@gmail.com");
		contact.setId(1);
		int row = service.update(contact);
		assertEquals(1, row);
	}
	
	@Test
	@Order(3)
	void delete() {
		var contact = new Contact();
		contact.setActive(false);
		contact.setId(7);
		int row = service.delete(contact);
		assertEquals(1, row);
	}
}









