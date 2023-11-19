package com.jdc.mkt.test;

import static org.junit.jupiter.api.Assertions.assertFalse;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import com.jdc.mkt.entity.Category;
import com.jdc.mkt.entity.Item;

public class CascadeOperationTest extends JpaFactory{

	
	//@ParameterizedTest
	@CsvSource("snack,sunflower seeds ,1200")
	void testPersist(String cName, String pName, int price) {

		// transient state
		var cat = new Category(cName);
		var item = new Item(pName,price,cat);
		
		var em = emf.createEntityManager();
		em.getTransaction().begin();
		em.persist(item);
		em.getTransaction().commit();
	}
	
	//@ParameterizedTest
	@CsvSource("snack,sunflower seeds ,1200")
	void testMerge(String cName, String pName, int price) {

		// transient state
		var cat = new Category(cName);
		var item = new Item(pName,price,cat);
		
		var em = emf.createEntityManager();
		em.getTransaction().begin();
		em.merge(item);
		em.getTransaction().commit();
	}
	
	//@ParameterizedTest
	@CsvSource("snack,sunflower seeds ,1200")
	void testRemove(String cName, String pName, int price) {
		var em = emf.createEntityManager();
		
		//to be manage state
		var cat = em.find(Category.class, 1);
		
		em.getTransaction().begin();
		em.remove(cat);
		em.getTransaction().commit();
	}
	
	@ParameterizedTest
	@CsvSource("snack,sunflower seeds ,1200")
	void testDetached(String cName, String pName, int price) {
		var em = emf.createEntityManager();
		
		//to be manage state
		var item = em.find(Item.class, 1);
		
		em.getTransaction().begin();
		//to be detached
		em.detach(item);
		
		assertFalse(em.contains(item.getCategory()));
		
		em.getTransaction().commit();
	}
	
}
