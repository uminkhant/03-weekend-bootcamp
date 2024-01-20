package com.jdc.mkt.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.jdc.mkt.entity.Address;

public interface AddressRepo extends JpaRepository<Address, Integer>,JpaSpecificationExecutor<Address> {

}
