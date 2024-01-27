package com.jdc.mkt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.jdc.mkt.entity.Category;
import com.jdc.mkt.entity.Category_;
import com.jdc.mkt.entity.Product;
import com.jdc.mkt.entity.Product_;
import com.jdc.mkt.repo.CategoryRepo;

@Service
public class CategoryService {
	@Autowired
	CategoryRepo repo;
	
	/*
	 * select c from Category c where c.id in
	 *(select p.category.id from Product p where lower(p.name) like lower(?1))
	 */
	
	public List<Category> selectCategoryWithJpqlQuery(String name){
		return repo.selectCategoryByProductNameLike(name);
	}
	
	public List<Category> selectCategoryWithSpec(String name){
		Specification<Category> spec = (root,query,cb) -> {
			//c.id
			var sub = query.subquery(Integer.class);
			//from Product p
			var product = sub.from(Product.class);
			//p.category.id
			var selector = product.get(Product_.category).get(Category_.id);
			//select p.category.id
			sub.select(selector);
			//where lower(p.name) like lower(?1)
			sub.where(cb.like(cb.lower( product.get(Product_.name)),name.toLowerCase().concat("%")));
			
			return root.get(Category_.id).in(sub);
		};
		return repo.findAll(spec);
	}
}
