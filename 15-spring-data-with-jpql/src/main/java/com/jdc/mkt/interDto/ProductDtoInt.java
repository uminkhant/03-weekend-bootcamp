package com.jdc.mkt.interDto;

import org.springframework.beans.factory.annotation.Value;

public interface ProductDtoInt {

	//String getName();
	//int getDtPrice();
	
	@Value("#{target.name+ ' ' +target.dtPrice}")
	String getDisplayName();
	
	default void getProduct() {
		//System.out.println("Name :%s\tprice :%d".formatted(getName(),getDtPrice()));
		System.out.println(getDisplayName());
	}
	
	
}
