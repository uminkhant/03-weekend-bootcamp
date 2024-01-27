package com.jdc.mkt;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.jdc.mkt.service.AddressService;

@SpringBootTest
public class AddressTest {

	@Autowired
	AddressService service;
	
	@Test
	@Disabled
	void findAddressByCustomerName() {
		var list = service.selectAddressWithJpqlQuery("andrew");
		list.forEach(a -> System.out.println(a.getStreet()));
	}
	@Test
	void findAddressByCustomerNameWithSpec() {
		var list = service.selectAddressWithSpec("andrew");
		list.forEach(a -> System.out.println(a.getStreet()));
	}
	@Test
	@Disabled
	void findAddressByTownshipAndCity() {
		var list = service.findByTownshipAndCityStaticWay("Maharaungmyay", "Mandalay");
		System.out.println(list);
	}
	@Test
	@Disabled
	void findAddressByTownshipWithSpecification() {
		var list = service.findByTownship("Maharaungmyay");
		System.out.println(list);
	}
	@Test
	@Disabled
	void findAddressByCity() {
		var list = service.findByCity("Yangon");
		System.out.println(list);
	}
}
