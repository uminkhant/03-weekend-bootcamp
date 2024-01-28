package com.jdc.mkt.sortAndPage;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Sort;

import com.jdc.mkt.dto.ProductDto;
import com.jdc.mkt.entity.Product;
import com.jdc.mkt.service.sort.ProductService;

@SpringBootTest
public class ProductSortTest {
	
	@Autowired
	ProductService service;
	
	@Test
	void testselectProductWtihProjectAndSort() {
		var typeSort = Sort.sort(ProductDto.class);
		var list = service.selectProductByDtPrice(1000, typeSort.by(ProductDto::getDtPrice).ascending());
		list.forEach(p -> System.out.println(p.getName()+"\t"+p.getDtPrice()));
	}
	
	@Test
	@Disabled
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
