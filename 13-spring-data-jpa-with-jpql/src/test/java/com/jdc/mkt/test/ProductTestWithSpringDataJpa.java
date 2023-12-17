package com.jdc.mkt.test;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import com.jdc.mkt.ApplicationConfig;
import com.jdc.mkt.entity.Category;
import com.jdc.mkt.entity.Product;
import com.jdc.mkt.entity.Product.Size;
import com.jdc.mkt.repo.ProductRepo;

@SpringJUnitConfig(classes = ApplicationConfig.class)
public class ProductTestWithSpringDataJpa {

	@Autowired
	ProductRepo repo;
	
	@Test
	void create() {
		var c = new Category();
		c.setId(1);
		var p = new Product("Lemon",500.0,c,LocalDate.now());
		
		p.setSize(Size.SMALL);
		repo.save(p);
	}
}
