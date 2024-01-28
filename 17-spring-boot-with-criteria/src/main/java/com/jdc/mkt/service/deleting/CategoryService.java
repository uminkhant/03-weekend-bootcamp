package com.jdc.mkt.service.deleting;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.jdc.mkt.entity.Category;
import com.jdc.mkt.entity.Category_;
import com.jdc.mkt.entity.Product;
import com.jdc.mkt.entity.Product_;
import com.jdc.mkt.repo.CategoryRepo;
import com.jdc.mkt.repo.ProductRepo;

@Service("deleteCategory")
public class CategoryService {

	@Autowired
	CategoryRepo repo;
	@Autowired
	ProductRepo pRepo;
	
	public void deleteByCategoryId(int id) {
		 repo.deleteById(id);
	}
	
	public long deleteCategoryByCategoryIdWithSpec(int id) {
		deleteProductByCategoryIdWithSpec(id);
		Specification<Category> spec = 
				(root,query,cb) -> cb.equal(root.get(Category_.id), id);
				return repo.delete(spec);
	}
	
	public long deleteProductByCategoryIdWithSpec(int id) {
		Specification<Product> spec = 
				(root,query,cb) -> 
		cb.equal(root.get(Product_.category).get(Category_.id), id);
		return pRepo.delete(spec);
	}
	
}
