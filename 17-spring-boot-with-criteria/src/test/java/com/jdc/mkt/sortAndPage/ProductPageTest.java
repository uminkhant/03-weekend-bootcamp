package com.jdc.mkt.sortAndPage;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import com.jdc.mkt.entity.Product;
import com.jdc.mkt.service.paging.ProductService;

@SpringBootTest
public class ProductPageTest {
	
	@Autowired
	ProductService service;
	
	@Test
	void testProductCountByDtPrice() {
		var result = service.selectProductCountByDtPrice(2000,PageRequest.of(0, 10));
		
		System.out.println(result.getTotalElements());
		System.out.println(result.getNumberOfElements());
		System.out.println(result.getNumber());
		System.out.println(result.getSize());
		
		for(Product p:result.toList()) {
			System.out.println(p.getName());
		}
	}
	
	@Test
	@Disabled
	void testProductByCategoryName() {
		var page = PageRequest.of(1, 3, Sort.by("name").ascending());
		var list = service.selectProductByCategoryName("Fruits",page);
		list.forEach(p -> System.out.println( p.getName()));
	}
}
