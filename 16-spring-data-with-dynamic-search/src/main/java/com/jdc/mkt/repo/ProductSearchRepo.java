package com.jdc.mkt.repo;

import java.util.List;

import org.springframework.lang.Nullable;

import com.jdc.mkt.entity.Product;

public interface ProductSearchRepo {

	List<Product> search(@Nullable String cName,@Nullable String pName,@Nullable Integer sPrice,@Nullable Integer ePrice);
}
