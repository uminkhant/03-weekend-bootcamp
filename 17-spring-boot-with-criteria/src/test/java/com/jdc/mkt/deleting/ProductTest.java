package com.jdc.mkt.deleting;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import com.jdc.mkt.service.deleting.ProductService;


@SpringBootTest
public class ProductTest {

	@Autowired
	ProductService service;
	
	@Test
	@Transactional
	@Rollback(false)
	public void testDeleteByCategoryName() {
		//var result = service.deleteByCategoryName("Fruits");
		var result = service.deleteByCategoryNameWithSpec("Fruits");
		System.out.println("Result :"+result);
	}
}
