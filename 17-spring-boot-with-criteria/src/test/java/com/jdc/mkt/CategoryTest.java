package com.jdc.mkt;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.jdc.mkt.service.CategoryService;

import jakarta.transaction.Transactional;

@SpringBootTest
public class CategoryTest {
	@Autowired
	CategoryService service;
	
	//@Test
	@Transactional
	void selectCategoryByProductNameLike() {
		var list = service.selectCategoryWithJpqlQuery("p".concat("%"));
		list.forEach(c -> System.out.println("Category :%s  Products :%s".formatted(c.getName(),c.getProducts())));
	}
	
	@Test
	@Transactional
	void selectCategoryByProductNameLikeWithSpec() {
		var list = service.selectCategoryWithSpec("p");
		list.forEach(c -> System.out.println("Category :%s  Products :%s".formatted(c.getName(),c.getProducts())));
	}
}
