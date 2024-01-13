package com.jdc.mkt.test;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import com.jdc.mkt.AppConfig;
import com.jdc.mkt.repo.ProductRepo;

@SpringJUnitConfig(classes = AppConfig.class)
public class ProductTest {

	@Autowired
	ProductRepo repo;

	//@Test
	void findOneByName() {
		
	}
	@Test
	@Disabled
	void findByCategoryAndPrice() {
		var list = repo.findByCategoryAndDtPrice("Diary", 1000,3000);
		list.forEach(p -> System.out.println(p.getName()+"\t"+p.getDtPrice()));
	}
	
	@Test
	//@Disabled
	void findProduct() {
		var list = repo.findProducts();
		list.forEach(p -> p.getProduct());
	}
	
	@Test
	@Disabled
	void findProductWithCategory() {
		var list = repo.findProductByCategory("Diary");
		list.forEach(p -> System.out.println(p.getCategory().getName()+"\t"+p.getProduct()+"\t"+p.getPrice()));
	}
}
