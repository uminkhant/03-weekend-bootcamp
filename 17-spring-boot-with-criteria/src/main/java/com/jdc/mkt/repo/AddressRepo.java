package com.jdc.mkt.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import com.jdc.mkt.entity.Address;

public interface AddressRepo extends JpaRepository<Address, Integer>,JpaSpecificationExecutor<Address> {

	@Query("""
			select a from Address a where a.id in
			(select c.address.id from Customer c where lower(c.name) = lower(?1))
			""")
	List<Address> selectAddressByCustomerName(String name);
}
