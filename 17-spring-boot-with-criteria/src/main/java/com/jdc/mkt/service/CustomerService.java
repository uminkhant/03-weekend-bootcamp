package com.jdc.mkt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.jdc.mkt.entity.Customer;
import com.jdc.mkt.entity.Customer_;
import com.jdc.mkt.repo.CustomerRepo;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Service
public class CustomerService {

	@PersistenceContext
	EntityManager em;
	@Autowired
	CustomerRepo repo;
	
	public List<Customer> findCustomerByNameAndEmail(String name,String email){
		Specification<Customer> predicate = Specification.anyOf(
				(root,query,cb) -> cb.equal(root.get(Customer_.name), name),
				(root,query,cb) -> cb.equal(root.get(Customer_.email), email)
				);
		return repo.findAll(predicate);
	}
	
	// select c from Customer c where c.address.city = :city
	public List<Customer> findCustomerByCity(String city) {
		var builder = em.getCriteriaBuilder();
		var criteria = builder.createQuery(Customer.class);
		
		//select c from Customer c
		var root = criteria.from(Customer.class);
		criteria.select(root);
		
		// where c.address.city = :city
		var predicate = builder.equal(root.get("address").get("city"), city);
		criteria.where(predicate);
		
		var query = em.createQuery(criteria);		
		return query.getResultList();
		
	}
}
