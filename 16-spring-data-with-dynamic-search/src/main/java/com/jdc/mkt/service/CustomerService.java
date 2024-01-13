package com.jdc.mkt.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.jdc.mkt.entity.Customer;
import com.jdc.mkt.repo.CustomerRepo;

@Service
public class CustomerService {

	@Autowired
	private CustomerRepo repo;

	public List<Customer> search(String name, String street, String township, String city) {

		var sb = new StringBuilder("select c from Customer c join c.address a where 1 = 1");
		var map = new HashMap<String, Object>();

		if (StringUtils.hasLength(name)) {
			sb.append(" and c.name = :name");
			map.put("name", name);
		}
		if (StringUtils.hasLength(street)) {
			sb.append(" and a.street = :street");
			map.put("street", street);
		}
		if (StringUtils.hasLength(township)) {
			sb.append(" and a.township = :township");
			map.put("township", township);
		}
		if (StringUtils.hasLength(city)) {
			sb.append(" and a.city = :city");
			map.put("city", city);
		}

		return repo.search(sb.toString(), map);
	}
}
