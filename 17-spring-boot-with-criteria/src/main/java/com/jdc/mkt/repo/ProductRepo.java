package com.jdc.mkt.repo;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;

import com.jdc.mkt.entity.Product;

public interface ProductRepo extends JpaRepositoryImplementation<Product, Integer>{

	long deleteProductByCategoryName(String name);
	
	//Paging
	List<Product> findProductByCategoryName(String name,Pageable page);
	
	@Query(
			value = "select p from Product p where p.dtPrice >= ?1",
			countQuery = "select count(p) from Product p where p.dtPrice >= ?1"
			)
	Page<Product> findProductCountByDtPrice(int price,Pageable page);
	
	//Sorting
	
	List<Product> findProductByCategoryNameOrderByNameDesc(String category);
	
	@Query("""
			select p from Product p where p.category.name = ?1 order by p.name desc
			""")
	List<Product> findProductByCatName(String category);
	
	//with sort param
	List<Product> findProductByCategoryName(String category,Sort sort);
	
	@Query("""
			select p from Product p where p.category.name = ?1
			""")
	List<Product> findProductByCatName(String category,Sort sort);
	
}
