package com.jdc.mkt.test;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import com.jdc.mkt.entity.Contact;
import com.jdc.mkt.entity.Parent;

public class ParentTest extends JpaFactory{

	
	@ParameterizedTest
	@CsvSource({
		"U SanNaung,sannaung@gamil.com,099223232",
		"Daw Thida,thida@gmail.com,099882342"
		})
	void insertParent(String name,String email,String phone) {
		
		var em =  emf.createEntityManager();
		em.getTransaction().begin();
		
		var contact = new Contact(email,phone);
		em.persist(contact);
		
		var p = new Parent();
		em.persist(p);
		
		em.getTransaction().commit();
		
		//var parent = em.find(Parent.class, 1);
	}
	
}
