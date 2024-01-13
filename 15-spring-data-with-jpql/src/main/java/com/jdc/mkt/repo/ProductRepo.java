package com.jdc.mkt.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.jdc.mkt.entity.Product;
import com.jdc.mkt.interDto.ProductDtoInt;
import com.jdc.mkt.interDto.ProductNameAndPriceDtoInt;

public interface ProductRepo extends JpaRepository<Product, Integer>{

	//custom query method
	Product findOneByName(String name);
	
	//name query
	List<Product> findByCategoryAndDtPrice(@Param("category") String category,@Param("low") int lowPrice,@Param("high") int highPrice);
	
	//query with projection interface
	@Query("select p.name name,p.dtPrice dtPrice from Product p")
	List<ProductDtoInt> findProducts();
	
	@Query("select p.category category,p.name product ,p.dtPrice price from Product p where p.category.name = :cat")
	List<ProductNameAndPriceDtoInt> findProductByCategory(@Param("cat") String cat);
	
	
}
