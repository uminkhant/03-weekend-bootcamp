package com.jdc.mkt.dto;

public record SelectProductNamePriceQtyAndTotalByCategoryName(
		String name,
		int price,
		long qty,
		long total
		) {

}
