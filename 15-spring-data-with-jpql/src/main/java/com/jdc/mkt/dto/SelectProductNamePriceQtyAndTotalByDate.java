package com.jdc.mkt.dto;

public record SelectProductNamePriceQtyAndTotalByDate(
		String name,
		int price,
		long qty,
		long total
		) {

}
