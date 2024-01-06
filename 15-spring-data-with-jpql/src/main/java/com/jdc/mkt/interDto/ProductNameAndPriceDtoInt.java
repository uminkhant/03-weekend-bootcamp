package com.jdc.mkt.interDto;

import com.jdc.mkt.repo.CategoryDtoInt;

public interface ProductNameAndPriceDtoInt {

	CategoryDtoInt getCategory();
	String getProduct();
	int getPrice();
}
