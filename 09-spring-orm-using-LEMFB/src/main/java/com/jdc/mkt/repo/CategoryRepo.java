package com.jdc.mkt.repo;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.jdc.mkt.entity.Category;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Repository
public class CategoryRepo {

	@PersistenceContext
	EntityManager em;
	
	@Transactional
	public Category create(Category category) {
		em.persist(category);
		return category;
	}
}
