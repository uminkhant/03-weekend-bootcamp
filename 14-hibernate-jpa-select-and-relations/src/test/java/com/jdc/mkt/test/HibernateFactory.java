package com.jdc.mkt.test;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class HibernateFactory {

	
	static EntityManagerFactory emf;
	
	@BeforeAll
	static void init() {
		emf = Persistence.createEntityManagerFactory("select-and-relations");
	}
	
	@AfterAll
	static void closeEmf() {
		if(null != emf && emf.isOpen())
			emf.close();
	}
	
	@Test
	void test() {
		
	}
}
