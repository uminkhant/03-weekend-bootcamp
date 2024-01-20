package com.jdc.mkt.repo.example;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jdc.mkt.entity.Address;

public interface AddressExampleRepo extends JpaRepository<Address, Integer> {

	
}
