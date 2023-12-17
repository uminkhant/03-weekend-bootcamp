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
	@ValueSource(strings = "Fruits")
	void create(String name) {
		var c = repo.create(new Category(name));
		assertNotNull(c);
	}
}
