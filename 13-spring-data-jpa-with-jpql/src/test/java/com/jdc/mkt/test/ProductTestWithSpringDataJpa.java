package com.jdc.mkt.test;

import java.time.LocalDate;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import com.jdc.mkt.ApplicationConfig;
import com.jdc.mkt.entity.Category;
import com.jdc.mkt.entity.Product;
import com.jdc.mkt.entity.Product.Size;
import com.jdc.mkt.repo.ProductRepo;

@SpringJUnitConfig(classes = ApplicationConfig.class)
@TestMethodOrder(OrderAnnotation.class)
public class ProductTestWithSpringDataJpa {

	@Autowired
	ProductRepo repo;
	
	@Test
	@Order(1)
	void create() {
		var c = new Category();
		c.setId(1);
		var p = new Product("Lemon",500.0,c,LocalDate.now());
		
		p.setSize(Size.SMALL);
		repo.save(p);
		
	}
	
	@Test
	@Order(2)
	void selectProductByCatName() {
		var list = repo.selectProductCatName("Fruits");
		list.forEach(p -> System.out.println(p.getName()));
	}
}
