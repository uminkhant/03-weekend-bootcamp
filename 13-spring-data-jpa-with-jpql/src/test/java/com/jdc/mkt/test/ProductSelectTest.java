package com.jdc.mkt.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

public class ProductSelectTest extends FactoryForHibernateJpa{
	
	@Test
	@Order(1)
	void selectProductByNameAndPrice() {
		var list = service.selectWithQuery("Orange", 2000);
		list.forEach(p -> System.out.println(p.getName()));
	}
	
	@Test
	@Order(2)
	void selectProductByCategoryName() {
		var list = service.selectWithQueryByCatName("Fruits");
		list.forEach(p -> System.out.println(p.getName()));
	}
	
	@Test
	@Order(3)
	void selectProductByProductNameLike() {
		var list = service.selectWithNamedQueryByProductNamedLike("o");
		list.forEach(p -> System.out.println(p.getName()));
	}
	
	@Test
	@Order(4)
	void selectProudctCount() {
		var row = service.selectProductCount("");
		assertEquals(6, row);
	}
}
