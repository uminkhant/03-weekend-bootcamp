package com.jdc.mkt.sortAndPage;

import javax.swing.SortOrder;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Sort;

import com.jdc.mkt.entity.Product;
import com.jdc.mkt.service.sortAndPaging.ProductService;

@SpringBootTest
public class ProductTest {
	
	@Autowired
	ProductService service;
	
	@Test
	//@Disabled
	void testSelectProductWithSpecAndTypeSort() {
		var typeSort = Sort.sort(Product.class);
		var list = service.
				selectProductByCatgoryNameWithSpec
				("Fruits",typeSort.by(Product::getName).descending());
		list.forEach(p -> System.out.println(p.getName()));
	}
	
	@Test
	@Disabled
	void testSelectProduct() {
		var list = service.selectProductByCategoryName("Fruits");
		list.forEach(p -> System.out.println(p.getName()));
	}
	
	@Test
	@Disabled
	void testSelectProductWithJpql() {
		var list = service.selectProductByCategoryNameWithJpql("Fruits");
		list.forEach(p -> System.out.println(p.getName()));
	}
	
	@Test
	@Disabled
	void testSelectProductWithSort() {
		var list = service.selectProductByCategoryNameWithSort("Fruits",Sort.by("name").descending());
		list.forEach(p -> System.out.println(p.getName()));
	}
	
	@Test
	@Disabled
	void testSelectProductWithJpqlAndSort() {
		var list = service.selectProductByCategoryNameWithJpqlAndSort("Fruits",Sort.by("name").ascending());
		list.forEach(p -> System.out.println(p.getName()));
	}
}
