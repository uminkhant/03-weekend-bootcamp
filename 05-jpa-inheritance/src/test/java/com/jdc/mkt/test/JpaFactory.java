package com.jdc.mkt.test;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;

public class JpaFactory {

	static EntityManagerFactory emf;
	
	@BeforeAll
	static void init() {
		emf = Persistence.createEntityManagerFactory("jpa-inheritance");
	}
	
	
	@AfterAll
	static void closeEmf() {
		if(null != emf &&  emf.isOpen())
			emf.close();
	}
	
	
}
