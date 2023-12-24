package com.jdc.mkt.test;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;

import com.jdc.mkt.service.ProductService;

@TestMethodOrder(OrderAnnotation.class)
public class FactoryForHibernateJpa {

static ProductService service;
	
	@BeforeAll
	static void init() {
		service = new ProductService();
				
	}
}
