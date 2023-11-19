package com.jdc.mkt.test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import javax.persistence.PersistenceException;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import com.jdc.mkt.entity.Category;
import com.jdc.mkt.entity.Item;

@TestMethodOrder(OrderAnnotation.class)
public class StateOperationTest extends JpaFactory {

	// @ParameterizedTest
	@CsvSource({ "snack,sunflower seeds ,1200" })
	@Order(1)
	void testPersist(String cName, String pName, int price) {

		// to be transient state
		var cat = new Category(cName);
		var item = new Item(pName, price, cat);

		var em = emf.createEntityManager();
		em.getTransaction().begin();
		// to be transient state
		em.persist(cat);
		em.persist(item);
		assertTrue(em.contains(item));

		// to be remove state
		em.remove(item);
		assertFalse(em.contains(item));

		// to be managed state
		em.persist(item);
		assertTrue(em.contains(item));

		// to be detached state
		em.detach(item);
		assertFalse(em.contains(item));

		// to be managed state
		assertThrows(PersistenceException.class, () -> em.persist(item));

		em.getTransaction().commit();

	}

	// @ParameterizedTest
	@CsvSource({ "snack" })
	@Order(2)
	void testMerge(String cName) {

		var em = emf.createEntityManager();
		em.getTransaction().begin();

		// to be transient state
		var cat = new Category(cName);

		// to be managed state
		var cat1 = em.merge(cat);
		assertTrue(em.contains(cat1));

		// to be detached state from manage
		em.detach(cat1);
		assertFalse(em.contains(cat1));

		// to be managed from detached
		var cat2 = em.merge(cat1);
		assertTrue(em.contains(cat2));

		// to be removed state from manage
		em.remove(cat2);

		// to be managed state from remove
		assertThrows(IllegalArgumentException.class, () -> em.merge(cat2));

		em.getTransaction().commit();

	}

	@ParameterizedTest
	@CsvSource({ "snack" })
	@Order(3)
	void testRemove(String cName) {

		var em = emf.createEntityManager();
		em.getTransaction().begin();

		// to be managed state
		//var item = em.find(Item.class, 1);

		// to be remove from manage
		//em.remove(item);
		//assertFalse(em.contains(item));
		

		// to be managed state
		var item1 = em.find(Item.class, 1);
		
		//to be detached from manage
		em.detach(item1);
		
		//to be manage from detached
		assertThrows(IllegalArgumentException.class, () -> em.remove(item1));
		em.getTransaction().commit();
		

	}
}
