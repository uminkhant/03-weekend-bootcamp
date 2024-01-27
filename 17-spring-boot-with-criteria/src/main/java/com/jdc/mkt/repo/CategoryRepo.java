package com.jdc.mkt.repo;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;

import com.jdc.mkt.entity.Category;

public interface CategoryRepo extends JpaRepositoryImplementation<Category, Integer>{

	@Query("""
			select c from Category c where c.id in
			(select p.category.id from Product p where lower(p.name) like lower(?1))
			""" )
	List<Category> selectCategoryByProductNameLike(String name);
	
}
