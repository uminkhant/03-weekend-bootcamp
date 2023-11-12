package com.jdc.mkt.convert;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter
public class PhoneConverter implements AttributeConverter<Integer, String>{

	@Override
	public String convertToDatabaseColumn(Integer phone) {
		return "09-"+String.valueOf(phone);
	}

	@Override
	public Integer convertToEntityAttribute(String phone) {
		var arr = phone.split("-");
		return Integer.parseInt(arr[1]);
	}

}
