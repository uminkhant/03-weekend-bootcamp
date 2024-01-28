package com.jdc.mkt.service.paging;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.jdc.mkt.entity.Product;
import com.jdc.mkt.repo.ProductRepo;

@Service("PagingProduct")
public class ProductService {

	@Autowired
	ProductRepo repo;
	
	public List<Product> selectProductByCategoryName(String name,Pageable page){
		return repo.findProductByCategoryName(name, page);
	}
	
	public Page<Product> selectProductCountByDtPrice(int price,Pageable page){
		return repo.findProductCountByDtPrice(price,page);
	}
	
	
}
