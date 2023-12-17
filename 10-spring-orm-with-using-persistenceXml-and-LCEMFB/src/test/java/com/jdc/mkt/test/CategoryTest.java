package com.jdc.mkt.test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import com.jdc.mkt.entity.Category;
import com.jdc.mkt.repo.CategoryRepo;

//@SpringJUnitConfig(classes = ApplicationConfig.class)
@SpringJUnitConfig(locations = "/application.xml")
public class CategoryTest {

	@Autowired
	CategoryRepo repo;
	
	@ParameterizedTest
	@ValueSource(strings="Fruits")
	void test1(String name) {
		var c = repo.insert(new Category(name));
		assertNotNull(c);
	}
}
