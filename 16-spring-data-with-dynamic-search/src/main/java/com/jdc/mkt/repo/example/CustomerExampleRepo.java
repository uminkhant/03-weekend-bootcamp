package com.jdc.mkt.repo.example;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jdc.mkt.entity.Customer;

public interface CustomerExampleRepo extends JpaRepository<Customer, Integer>{
	
}
