package com.jdc.mkt.test;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import com.jdc.mkt.entity.Category;
import com.jdc.mkt.entity.Product;

public class ProductTest extends EntityFactory{

	
	@ParameterizedTest
	@CsvSource({"Fruits,Orange,1000","Fruits,Apple,1500"})
	void insert(String name,String pName,int price) {
		var cat = new Category();
		cat.setName(name);
		var p = new Product();
		p.setName(pName);
		p.setPrice(price);
		p.setCategory(cat);
		em.getTransaction().begin();
		em.persist(cat);
		em.persist(p);
		em.getTransaction().commit();
	}
}
