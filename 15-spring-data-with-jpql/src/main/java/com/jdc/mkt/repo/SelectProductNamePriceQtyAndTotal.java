package com.jdc.mkt.repo;

import com.jdc.mkt.interDto.ProductDtoInt;

public interface SelectProductNamePriceQtyAndTotal {

	ProductDtoInt getProductName();
	ProductDtoInt getProductPrice();
	int getQty();
	int getTotal();
}
