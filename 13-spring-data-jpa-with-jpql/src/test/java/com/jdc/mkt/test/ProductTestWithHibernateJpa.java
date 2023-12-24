package com.jdc.mkt.test;

import java.time.LocalDate;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import com.jdc.mkt.entity.Category;
import com.jdc.mkt.entity.Product;
import com.jdc.mkt.entity.Product.Size;

public class ProductTestWithHibernateJpa extends FactoryForHibernateJpa {


	@Test
	@Order(1)
	void create() {
		var c = new Category();
		c.setId(1);
		var p = new Product("Lemon",500.0,c,LocalDate.now());
		p.setSize(Size.LARGE);
		service.createWithQuery(p);
	}
	
	@Test
	@Order(2)
	void update() {
		var c = new Category();
		c.setId(1);
		var p = new Product("Watermelon",1500.0,c,LocalDate.now());
		p.setSize(Size.LARGE);
		service.updateWithQuery(p, "Lemon");;
	}
	
	
}
