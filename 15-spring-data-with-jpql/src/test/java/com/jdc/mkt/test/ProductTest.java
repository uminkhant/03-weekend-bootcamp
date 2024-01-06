package com.jdc.mkt.test;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import com.jdc.mkt.AppConfig;
import com.jdc.mkt.repo.ProductRepo;

@SpringJUnitConfig(classes = AppConfig.class)
public class ProductTest {

	@Autowired
	ProductRepo repo;
	
	@Test
	void test() {
//		var list = repo.findAll();
//		list.forEach(p -> System.out.println(p.getName()));
	}
}
