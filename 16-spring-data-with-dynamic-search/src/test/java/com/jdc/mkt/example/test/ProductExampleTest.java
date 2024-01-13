package com.jdc.mkt.example.test;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.ExampleMatcher.NullHandler;
import org.springframework.data.domain.ExampleMatcher.StringMatcher;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import com.jdc.mkt.AppConfig;
import com.jdc.mkt.entity.Category;
import com.jdc.mkt.entity.Product;
import com.jdc.mkt.repo.ProductRepo;

@SpringJUnitConfig(classes = AppConfig.class)
public class ProductExampleTest {

	@Autowired
	ProductRepo repo;
	
	@Test
	@Disabled
	void testExample() {
		var prob = new Product();
		prob.setName("Milk");
		var example = Example.of(prob);
		var list = repo.findAll(example);
		System.out.println(list);
	}
	
	@Test
	@Disabled
	void testExampleWithExampleMatcher() {
		var probe = new Product();
		probe.setName("m");
		probe.setCategory(new Category("Fruits"));
		var example = Example.of(probe,
				ExampleMatcher.matchingAny()
				.withIgnoreNullValues()
				.withIgnoreCase()
				.withStringMatcher(StringMatcher.STARTING));
		var list = repo.findAll(example);
		list.forEach(p -> System.out.println(p.getName()+"\t"+p.getCategory().getName()));
	}
	
	@Test
	@Disabled
	void testExampleMatcherWithIgnoreNullAndStringMatcher() {
		var probe = new Product();
		probe.setName("s");
		//probe.setCategory(new Category("Diary"));
		var example = Example.of(probe,
				ExampleMatcher.matchingAny()
				//.withIncludeNullValues()
				.withNullHandler(NullHandler.IGNORE)
				.withIgnoreCase()
				.withStringMatcher(StringMatcher.ENDING));
		var list = repo.findAll(example);
		list.forEach(p -> System.out.println(p.getName()+"\t"+p.getCategory().getName()));
	}
	
	@Test
	void testExampleWithIgnorePaths() {
		var probe = new Product();
		probe.setName("m");
		probe.setDtPrice(300);
		probe.setCategory(new Category("Fruits"));
		var example = Example.of(probe,
				ExampleMatcher.matchingAll()
				.withIgnorePaths("category","dtPrice")
				.withIgnoreCase()
				.withStringMatcher(StringMatcher.STARTING));
				
		var list = repo.findAll(example);
		list.forEach(p -> System.out.println(p.getName()+"\t"+p.getCategory().getName()));
	}
	
}
