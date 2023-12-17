package com.jdc.mkt.test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.transaction.annotation.Transactional;

import com.jdc.mkt.entity.Product.Size;

public class ProductTest extends FactoryTest{
	
	@Test
	@Order(1)
	void findById() {		
		var p = productRepo.findById(1).get();
		assertAll(() -> {
			assertNotNull(p);
			assertEquals("Orange", p.getName());
			assertEquals(2000, p.getPrice());
			
		});
	}
	
	@Test
	@Order(2)
	void findByName() {		
		var list = productRepo.findByName("Orange");
		var p = list.stream().findFirst().get();
		
		assertAll(() -> {
			assertNotNull(p);
			assertEquals("Orange", p.getName());
			assertEquals(2000, p.getPrice());
			
		});
	}
	
	@Test
	@Order(3)
	void getByNameAndPrice() {		
		var list = productRepo.getByNameAndPrice("Orange",2000);
		var p = list.stream().findFirst().get();
		
		assertAll(() -> {
			assertNotNull(p);
			assertEquals("Orange", p.getName());
			assertEquals(2000, p.getPrice());
			
		});
	}
	
	@Test
	@Order(4)
	void countBySize() {
		var size = productRepo.countBySize(Size.MEDIUM);
		assertEquals(3, size);
	}
	
	@Test
	@Order(5)
	void exitByName() {
		var exist = productRepo.existsByName("MayMyo");
		assertTrue(exist);
	}
	
	@Test
	@Order(6)
	void findFirst2BySize() {
		var list = productRepo.findFirst2BySize(Size.MEDIUM);
		assertEquals(2, list.size());
	}
	
	@Test
	@Order(7)
	@Transactional
	void deleteBySize() {
		 productRepo.deleteBySize(Size.MEDIUM);
		assertEquals(2,productRepo.findAll().size());
	}
	
	@Test
	@Order(8)
	@Transactional
	void findByCategoryName() {
		 var list = productRepo.findByCategoryName("Drinks");
		assertEquals(2,list.size());
	}
	
	
	
	
	
	
	
	
	
	
}
