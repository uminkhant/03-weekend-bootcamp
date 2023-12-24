package com.jdc.mkt.service;

import java.util.List;
import java.util.stream.Stream;

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
	
	
	public void updateWithQuery(Product p,String indexName) {
		var em = emf.createEntityManager();
		var query = em.createQuery("update Product p set p.name = ?1, p.price = ?2 where p.name = ?3");
		query.setParameter(1, p.getName());
		query.setParameter(2, p.getPrice());
		query.setParameter(3, indexName);
		
		em.getTransaction().begin();
		query.executeUpdate();
		em.getTransaction().commit();
		em.close();
		
	}
	
	public List<Product> selectWithQuery(String name ,int price) {
		var em = emf.createEntityManager();
		var query = em.createQuery("select p from Product p where p.name = :name and p.price <= :price",Product.class);
		query.setParameter("name", name);
		query.setParameter("price", price);
		
		var list = query.getResultList();
		return list;
	}
	
	public List<Product> selectWithQueryByCatName(String name ) {
		var em = emf.createEntityManager();
		//var query = em.createQuery("select p from Product p where p.category.name = :category",Product.class);
		var query = em.createNamedQuery("Product.selectProductByCatName",Product.class);
		query.setParameter("category", name);
		
		var list = query.getResultList();
		return list;
	}
	
	public Stream<Product> selectWithNamedQueryByProductNamedLike(String name ) {
		var em = emf.createEntityManager();
		var query = em.createNamedQuery("Product.selectProductByNameLike",Product.class);
		query.setParameter(1, name.concat("%"));
		
		var list = query.getResultStream();
		return list;
	}
	
	public Long selectProductCount(String name ) {
		var em = emf.createEntityManager();
		var query = em.createNamedQuery("Product.selectProductCount",Long.class);		
		return query.getSingleResult();
		
	}
	
}
