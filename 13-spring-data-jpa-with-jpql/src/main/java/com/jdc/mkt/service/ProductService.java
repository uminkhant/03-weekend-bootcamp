package com.jdc.mkt.service;

import com.jdc.mkt.entity.Product;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class ProductService {

	EntityManagerFactory emf;

	public ProductService() {
		emf = Persistence.createEntityManagerFactory("13-JPQL");
	}

	public void create(Product product) {

		var em = emf.createEntityManager();

		em.getTransaction().begin();
		em.persist(product);
		em.getTransaction().commit();
		em.close();

	}

	public void createWithQuery(Product product) {

		var em = emf.createEntityManager();
		var query = em.createQuery("insert into Product(name,price)values(?1,?2) ");
		query.setParameter(1, product.getName());
		query.setParameter(2, product.getPrice());
		
		em.getTransaction().begin();
		query.executeUpdate();
		em.getTransaction().commit();
		em.close();

	}
}
