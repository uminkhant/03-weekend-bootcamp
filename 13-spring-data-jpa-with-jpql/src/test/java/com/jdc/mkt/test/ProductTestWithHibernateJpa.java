package com.jdc.mkt.test;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.jdc.mkt.entity.Category;
import com.jdc.mkt.entity.Product;
import com.jdc.mkt.entity.Product.Size;
import com.jdc.mkt.service.ProductService;

public class ProductTestWithHibernateJpa {

	static ProductService service;
	
	@BeforeAll
	static void init() {
		service = new ProductService();
				
	}
	
	@Test
	void create() {
		var c = new Category();
		c.setId(1);
		var p = new Product("Lemon",500.0,c,LocalDate.now());
		p.setSize(Size.LARGE);
		service.createWithQuery(p);
	}
}
