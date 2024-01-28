package com.jdc.mkt.service.sort;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.jdc.mkt.dto.ProductDto;
import com.jdc.mkt.entity.Category_;
import com.jdc.mkt.entity.Product;
import com.jdc.mkt.entity.Product_;
import com.jdc.mkt.repo.ProductRepo;

@Service("SortProduct")
public class ProductService {

	@Autowired
	ProductRepo repo;
	
	public List<ProductDto> selectProductByDtPrice(int price,Sort sort){
		Specification<Product> spec = (root,query,cb) -> 
			cb.greaterThanOrEqualTo(root.get(Product_.dtPrice), price);
		return repo.findBy(spec, 
				q -> 
				q.project("name","dtPrice","category")
				.as(ProductDto.class)
				.sortBy(sort)
				.all());
	}
	
	public List<Product> selectProductByCatgoryNameWithSpec(String category,Sort sort){
		Specification<Product> spec = 
				(root,query,cb) -> cb.equal(root.get(Product_.category).get(Category_.name), category);
			return repo.findAll(spec, sort);
	}
	
	public List<Product> selectProductByCategoryName(String category){
		return repo.findProductByCategoryNameOrderByNameDesc(category);
	}
	
	public List<Product> selectProductByCategoryNameWithJpql(String category){
		return repo.findProductByCatName(category);
	}
	
	public List<Product> selectProductByCategoryNameWithSort(String category,Sort sort){
		return repo.findProductByCategoryName(category,sort);
	}
	
	public List<Product> selectProductByCategoryNameWithJpqlAndSort(String category,Sort sort){
		return repo.findProductByCatName(category,sort);
	}
	
	
}
