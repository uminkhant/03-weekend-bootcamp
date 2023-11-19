package com.jdc.mkt.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import com.jdc.mkt.entity.Item;
import com.jdc.mkt.entity.ItemSize;

public class ItemSizeTest extends JpaFactory{

	@ParameterizedTest
	@CsvSource({"small,1","medium,1"})
	void testFetchMode(String name,int itemId) {
		var size = new ItemSize(name);
		var em = emf.createEntityManager();
		var item = em.find(Item.class, 1);
		size.addItem(item);
		em.getTransaction().begin();
		em.persist(size);
		em.getTransaction().commit();
		em.close();
		
		em = emf.createEntityManager();
		var size1 = em.find(ItemSize.class, 1);
		assertTrue(em.contains(size1));
		//em.close();
		var itemName = size1.getItems().stream().findFirst().get().getName();
		assertNotNull(itemName);
		assertEquals("orange", itemName);
		
	}
	
	
}
