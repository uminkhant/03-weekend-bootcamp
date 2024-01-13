package com.jdc.mkt.repo;

import java.util.List;

import com.jdc.mkt.entity.Product;

public interface ProductSearchRepo {

	List<Product> search(String cName,String pName,Integer sPrice,Integer ePrice);
}
