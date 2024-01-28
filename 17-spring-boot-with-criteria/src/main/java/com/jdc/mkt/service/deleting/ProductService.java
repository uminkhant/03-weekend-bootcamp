package com.jdc.mkt.service.deleting;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.jdc.mkt.entity.Category_;
import com.jdc.mkt.entity.Product;
import com.jdc.mkt.entity.Product_;
import com.jdc.mkt.repo.ProductRepo;

@Service("deleteProduct")
public class ProductService {
	
	@Autowired
	ProductRepo repo;
	
	public long deleteByCategoryName(String name) {
		return repo.deleteProductByCategoryName(name);
	}
	
	public long deleteByCategoryNameWithSpec(String name) {
		Specification<Product> spec = 
				(root,query,cb) -> 
				cb.equal(root.get(Product_.category)
						.get(Category_.name), name);
				
				return repo.delete(spec);
	}
}
