package com.jdc.mkt.test;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import com.jdc.mkt.entity.Category;
import com.jdc.mkt.entity.Item;

public class ItemTest  extends JpaFactory{

	@ParameterizedTest
	@CsvSource("Fruits,Apple,1200")
	void testPersist(String cName,String pName,int price) {
		
		var cat = new Category(cName);
		var item = new Item(cName,price,cat);
		
		var em = emf.createEntityManager();
		em.getTransaction().begin();
		em.persist(cat);
		em.persist(item);
		em.getTransaction().commit();
	}
	
}
