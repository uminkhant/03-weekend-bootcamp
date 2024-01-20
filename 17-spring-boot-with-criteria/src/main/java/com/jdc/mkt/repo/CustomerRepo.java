package com.jdc.mkt.repo;

import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;

import com.jdc.mkt.entity.Customer;

public interface CustomerRepo extends JpaRepositoryImplementation<Customer, Integer>{

}
