package com.jdc.mkt.repo;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jdc.mkt.entity.Product;
import com.jdc.mkt.entity.Product.Size;

public interface ProductRepo extends JpaRepository<Product, Integer> {

	List<Product> findByName(String name);

	List<Product> getByNameAndPrice(String name, double price);

	Long countBySize(Size size);

	boolean existsByName(String name);

	List<Product> findFirst2BySize(Size size);

	void deleteBySize(Size size);

	List<Product> findByCategoryName(String name);

	List<Product> findProductByNameAndCategoryNameAllIgnoreCase(String name, String cat);

	// string base

	List<Product> findProductByNameLike(String name);

	List<Product> findByNameStartsWith(String string);

	List<Product> findProductByNameStartingWith(String name);

	List<Product> findProductByPriceGreaterThanEqual(int price);

	// date
	List<Product> findProductByCreateDateAfter(LocalDate date);

	// null & empty
	List<Product> findProductByNameNotNull();

	// string base with ignore
	List<Product> findProductByNameLikeIgnoreCase(String name);

}
