package com.jdc.mkt.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.jdc.mkt.entity.Product;

public interface ProductRepo extends JpaRepository<Product, Integer>{
	
	@Query(name="Product.selectProductByCatName")
	List<Product> selectProductCatName(@Param("category") String name);
	
}
