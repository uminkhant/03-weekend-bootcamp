package com.jdc.mkt.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;


public class ProductTestTwo extends FactoryTest{
	
	@Test
	@Order(1)
	void findByCateogryNameOrProductName() {
		var list = productRepo.findProductByNameAndCategoryNameAllIgnoreCase("orange","fruits");
		assertEquals(1, list.size());
	}
	
	@Test
	@Order(2)
	void findByNameNotLike() {
		var list1 = productRepo.findProductByNameLike("m".concat("%"));
		assertEquals(2, list1.size());
		
		var list2 = productRepo.findProductByNameLikeIgnoreCase("m".concat("%"));
		assertEquals(2,list2.size());
	}
	
	@Test
	@Order(3)
	void findWithStartWith() {
		var list1 = productRepo.findByNameStartsWith("M");
		assertEquals(2, list1.size());
		
		var list2 = productRepo.findProductByNameStartingWith("M");
		assertEquals(2, list2.size());
	}
	
	@Test
	@Order(4)
	void findByPriceGreaterThanEqual() {
		var list = productRepo.findProductByPriceGreaterThanEqual(1000);
		assertEquals(3, list.size());
	}
	
	@Test
	@Order(5)
	void findByProductDateAfter() {
		var list = productRepo.findProductByCreateDateAfter(LocalDate.of(2023, 01, 10));
		assertEquals(4, list.size());
	}
	
	@Test
	@Order(6)
	void findProductByNameWithNotNull() {
		var list = productRepo.findProductByNameNotNull();
		assertEquals(5, list.size());
	}
	
	
	
}
