package com.jdc.mkt.example.test;

import java.util.List;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import com.jdc.mkt.AppConfig;
import com.jdc.mkt.entity.Product;
import com.jdc.mkt.service.example.ProductExampleService;

@SpringJUnitConfig(classes = AppConfig.class)
public class ProductSearchWithExample {
	
	@Autowired
	ProductExampleService service;
	
	@ParameterizedTest
	@CsvSource({
		"Diary,,,",
		",m,,",
		",,1,",
		",,1,1"})
	void testDynamicSearchExample(String category,String product,Integer catId,Integer pId) {
		var list = service.search(category, product, catId, pId);
		show(list);
	}
	void show(List<Product> list) {
		list.forEach(p -> System.out.printf("%s\t%s\t\n",p.getCategory().getName(),p.getName()));
		System.out.println();
		System.out.println("===============================================");
	}
}
