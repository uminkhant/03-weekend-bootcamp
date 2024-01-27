package com.jdc.mkt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.jdc.mkt.entity.Category_;
import com.jdc.mkt.entity.Product;
import com.jdc.mkt.entity.Product_;
import com.jdc.mkt.repo.ProductRepo;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Service
public class ProductService {

	@PersistenceContext
	private EntityManager em;
	@Autowired
	private ProductRepo repo;
	/*
	 * select p from Product p where p.category.name = ?1
	 */
	public List<Product> selectProductByCategoryNameWithSpec(String name){
		Specification<Product> spec = (root,query,cb) 
				-> cb.equal(root.get(Product_.category).get(Category_.name), name);
		return repo.findAll(spec);
	}
	
	public List<Product> selectProductByCategoryNameWithHibernateJpa(String name){
		var cb = em.getCriteriaBuilder();
		var query = cb.createQuery(Product.class);
		var root = query.from(Product.class);
		query.select(root);
		var predicate = cb.equal(root.get(Product_.category).get(Category_.name), name);
		query.where(predicate);
		return em.createQuery(query).getResultList();
	}
	
}
