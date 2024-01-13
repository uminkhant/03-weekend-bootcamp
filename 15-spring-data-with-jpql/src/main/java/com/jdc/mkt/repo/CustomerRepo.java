package com.jdc.mkt.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.jdc.mkt.entity.Customer;

public interface CustomerRepo extends JpaRepository<Customer, Integer>{

	@Query(name = "Customer.findAllByCityNam")
	List<Customer> findAllByCity(@Param("city") String city);
	
	@Query(nativeQuery = true)
	Customer findByNativeCustomerTownshipId(int addressId);
	
	@Query("select c from Customer c where c.address.city = :city and c.address.township = :town" )
	List<Customer> findAllByCityAndTownship(@Param("city")String  city,@Param("town") String township);
}
