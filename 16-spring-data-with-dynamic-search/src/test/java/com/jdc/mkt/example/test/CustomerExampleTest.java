package com.jdc.mkt.example.test;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.ExampleMatcher.GenericPropertyMatcher;
import org.springframework.data.domain.ExampleMatcher.StringMatcher;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import com.jdc.mkt.AppConfig;
import com.jdc.mkt.dto.CustomerDto;
import com.jdc.mkt.entity.Address;
import com.jdc.mkt.entity.Customer;
import com.jdc.mkt.repo.example.AddressExampleRepo;
import com.jdc.mkt.repo.example.CustomerExampleRepo;

@SpringJUnitConfig(classes = AppConfig.class)
public class CustomerExampleTest {

	@Autowired
	CustomerExampleRepo customerRepo;
	@Autowired
	AddressExampleRepo addressRepo;

	@Test
	void testCustomerProjection() {
		var customer = new Customer();
		var address = new Address();
		address.setTownship("mahar");
		customer.setAddress(address);

		var matcher = ExampleMatcher.matchingAll();
		matcher = matcher.withIgnoreCase().withStringMatcher(StringMatcher.STARTING);

		var example = Example.of(customer, matcher);

		var list = customerRepo.findBy(example,
				project -> project.
				project("name","email","address")
				.as(CustomerDto.class)
				.sortBy(Sort.by("name"))
				.all());
		
		list.forEach(c -> System.out.println(
					c.getName()+
				"\t"+c.getEmail()+
				"\t"+c.getAddress().getTownship()));
	}

	@Test
	@Disabled
	void testFindCustomerByCity() {
		var customer = new Customer();
		customer.setName("a");
		customer.setEmail("com");
		var address = new Address();
		address.setCity("yan");
		customer.setAddress(address);

		var matcher = ExampleMatcher.matching();
		matcher = matcher.withIgnoreCase().withStringMatcher(StringMatcher.STARTING)
				.withMatcher("name", query -> query.startsWith())
				.withMatcher("email", GenericPropertyMatcher.of(StringMatcher.ENDING));
		// .withMatcher("city",query -> query.exact());

		var example = Example.of(customer, matcher);

		var list = customerRepo.findAll(example);
		System.out.println(list);
	}

	@Test
	@Disabled
	void testFindAddressByCity() {
		var address = new Address();
		address.setCity("yangon");
		address.setTownship("test");

		var matcher = ExampleMatcher.matching();
		matcher = matcher.withIgnorePaths("id", "township").withIgnoreCase().withIgnoreNullValues();

		var example = Example.of(address, matcher);

		var list = addressRepo.findAll(example);
		System.out.println(list);
	}

}
