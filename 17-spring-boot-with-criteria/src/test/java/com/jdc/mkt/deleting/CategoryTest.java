package com.jdc.mkt.deleting;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import com.jdc.mkt.service.deleting.CategoryService;

@SpringBootTest
public class CategoryTest {
	
	@Autowired
	CategoryService service;
	
	@Test
	@Disabled
	@Transactional
	@Rollback(false)
	void deleteCategoryById() {
		 service.deleteByCategoryId(1);
		//System.out.println("Result : "+result);
	}
	
	@Test
	@Transactional
	@Rollback(false)
	void deleteCategoryByIdWithSpec() {
		 var result = service.deleteCategoryByCategoryIdWithSpec(1);
		System.out.println("Result : "+result);
	}
}
