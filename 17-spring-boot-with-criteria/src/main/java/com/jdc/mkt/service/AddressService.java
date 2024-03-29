package com.jdc.mkt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.jdc.mkt.entity.Address;
import com.jdc.mkt.entity.Address_;
import com.jdc.mkt.entity.Address_test;
import com.jdc.mkt.entity.Customer;
import com.jdc.mkt.entity.Customer_;
import com.jdc.mkt.repo.AddressRepo;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Service
public class AddressService {

	@Autowired
	AddressRepo repo;
	
	@PersistenceContext
	EntityManager em;
	
	/*
	 * select a from Address a where a.id in
     * (select c.address.id from Customer c where lower(c.name) = lower(?1))
	 */
	public List<Address> selectAddressWithJpqlQuery(String name){
		return repo.selectAddressByCustomerName(name);
	}
	
	public List<Address> selectAddressWithSpec(String name){
		Specification<Address> spec = (root,query,cb) -> {
			var sub = query.subquery(String.class);
			var customer = sub.from(Customer.class);
			var selector = customer.get(Customer_.address).get(Address_.city);
			sub.select(selector);
			sub.where(cb.equal(cb.lower(customer.get(Customer_.name)), name.toLowerCase()));
			return root.get(Address_.city).in(sub);
		};
		return repo.findAll(spec);
	}
	
	//select a from Address a where a.city = :city and a.township = :township
		public List<Address> findByTownshipAndCityStaticWay(String township,String city){
				Specification<Address> predicate = Specification.allOf(
						(root,query,cb)-> cb.equal(root.get(Address_test.city), city),
						(root,query,cb)-> cb.equal(root.get(Address_test.township), township));
			
			return repo.findAll(predicate);
		}
	
	//select a from Address a where a.city = :city and a.township = :township
	public List<Address> findByTownshipAndCity(String township,String city){
		Specification<Address> pre_township = (root,query,cb)-> cb.equal(root.get(Address_.township), township);
		Specification<Address> pre_city = (root,query,cb)-> cb.equal(root.get(Address_.city), city);
		pre_city =  pre_city.and(pre_township);	
		
		return repo.findAll(pre_city);
	}
	
	//select a from Address a where a.towhship = :township
	public List<Address> findByTownship(String township){
		Specification<Address> predicate = (root,query,cb)-> cb.equal(root.get("township"), township);
		return repo.findAll(predicate);
	}
	
	//select a from Address a where a.city = :city
	public List<Address> findByCity(String city){
		var criteriaBuilder = em.getCriteriaBuilder();
		var query = criteriaBuilder.createQuery(Address.class);
		
		//select a from Address
		var root = query.from(Address.class);
		query.select(root);
		
		//where a.city = :city
		var predicate = criteriaBuilder.equal(root.get("city"), city);		
		query.where(predicate);
				
		return em.createQuery(query).getResultList();
	}
}
