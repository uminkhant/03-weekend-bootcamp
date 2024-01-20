package com.jdc.mkt.service.example;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.jdc.mkt.entity.Category;
import com.jdc.mkt.entity.Product;
import com.jdc.mkt.repo.example.ProductExampleRepo;

@Service
public class ProductExampleService {
	
	@Autowired
	ProductExampleRepo repo;

	public List<Product> search(String category,String product,Integer catId,Integer pId){
		
		var cat = new Category();
		var prod = new Product();
		prod.setCategory(cat);
		prod.setDtPrice(500);
		
		var matcher = ExampleMatcher.matching();
		var excludes =new ArrayList<String>(List.of("id","dtPrice","wsPrice"))  ;
		
		if(null != catId && catId > 0) {
			excludes.remove("id");
			cat.setId(catId);			
		}
		
		if(null !=pId && pId > 0) {
			excludes.remove("id");
			prod.setId(catId);
		}
		
		if(StringUtils.hasLength(category)) {
			cat.setName(category);
			matcher = matcher.withMatcher("name", query -> query.exact());
		}
		
		if(StringUtils.hasLength(product)) {
			prod.setName(product);
			matcher = matcher.withMatcher("name", query -> query.startsWith().ignoreCase());
		}
		
		matcher = matcher.withIgnorePaths(excludes.toArray(s -> new String[s]));
		var example = Example.of(prod,matcher);
		return repo.findAll(example);
	}
	
}
