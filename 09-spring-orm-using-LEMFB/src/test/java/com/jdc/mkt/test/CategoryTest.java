package com.jdc.mkt.test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import com.jdc.mkt.ApplicationConfig;
import com.jdc.mkt.entity.Category;
import com.jdc.mkt.repo.CategoryRepo;

//@SpringJUnitConfig(locations = "/application.xml")
@SpringJUnitConfig(classes = ApplicationConfig.class)
public class CategoryTest {

	@Autowired
	CategoryRepo repo;
	
	@ParameterizedTest
	@CsvSource("Fruits,true")
	void test1(String name,boolean active) {
		var cat = repo.create(new Category(name, active));
		assertNotNull(cat);
	}
}
