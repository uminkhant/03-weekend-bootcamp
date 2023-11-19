package com.jdc.mkt.test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import com.jdc.mkt.entity.Category;
import com.jdc.mkt.entity.Item;

public class ItemTest extends JpaFactory {

	@ParameterizedTest
	@CsvSource("snack,sunflower seeds ,1200")
	void testPersist(String cName, String pName, int price) {

		// transient state
		//var cat = new Category(cName);
		
		var em = emf.createEntityManager();
		em.getTransaction().begin();
		// managed state
		//em.persist(cat);
		var cat = em.find(Category.class, 1);
		em.detach(cat);
		
		//var cat1 = em.merge(cat);
		var item = new Item(pName, price, cat);

		em.persist(item);
		em.getTransaction().commit();
	}

	//@Test
	void testUpdate() {
		var em = emf.createEntityManager();
		em.getTransaction().begin();
		
		//to be managed state
		var item = em.find(Item.class, 1);
		assertTrue(em.contains(item));
		
		item.setName("PileApple");
		
		//to be detached state
		em.detach(item);
		assertFalse(em.contains(item));
		
		//to be managed state
		var item1 = em.merge(item);
		assertTrue(em.contains(item1));
		
		em.getTransaction().commit();
		
	}
	
	//@Test
	void testRemove() {
		var em = emf.createEntityManager();
		em.getTransaction().begin();
		
		//to be managed state
		var item = em.find(Item.class, 1);
		assertTrue(em.contains(item));
		
		//to be removed state
		em.remove(item.getCategory());
		
		em.getTransaction().commit();
	}

	// @ParameterizedTest
	@CsvSource("Fruits,Apple,1200")
	void testManageState(String cName, String pName, int price) {

		// transient state
		var cat = new Category(cName);
		var item = new Item(pName, price, cat);

		var em = emf.createEntityManager();
		em.getTransaction().begin();

		// managed state
		em.persist(cat);
		em.persist(item);
		assertTrue(em.contains(item));

		item.setName("Orange");

		// detach state
		em.detach(item);
		assertFalse(em.contains(item));

		// to be managed state
		var item1 = em.merge(item);
		assertTrue(em.contains(item1));

		em.getTransaction().commit();

	}

	//@Test
	void testFind() {

		var em = emf.createEntityManager();
		// to be managed state
		var item = em.find(Item.class, 1);
		assertTrue(em.contains(item));
		assertAll(() -> assertEquals("orange", item.getName()), () -> assertEquals(1, item.getCategory().getId()),
				() -> assertEquals("fruits", item.getCategory().getName()));
		em.close();
	}

}
