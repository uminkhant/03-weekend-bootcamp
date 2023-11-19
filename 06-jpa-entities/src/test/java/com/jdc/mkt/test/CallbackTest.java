package com.jdc.mkt.test;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import com.jdc.mkt.entity.Category;
import com.jdc.mkt.entity.Item;

@TestMethodOrder(OrderAnnotation.class)
public class CallbackTest extends JpaFactory{

	@ParameterizedTest
	@CsvSource("snack,sunflower seeds ,1200")
	@Order(1)
	void testPersist(String cName, String pName, int price) {	
		var em = emf.createEntityManager();
		em.getTransaction().begin();
		
		var cat = em.find(Category.class, 1);
		var item = new Item(pName, price, cat);
		em.persist(item);
		
		em.getTransaction().commit();
	}
	
	@ParameterizedTest
	@CsvSource("snack,sunflower seeds ,1200")
	@Order(2)
	void testUpdate(String cName, String pName, int price) {	
		var em = emf.createEntityManager();
		em.getTransaction().begin();
		
		var item = em.find(Item.class, 1);
		item.setName("durian");	
		em.merge(item);	
		em.getTransaction().commit();
	}
}
