package com.jdc.mkt.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jdc.mkt.entity.Product;

public interface ProductRepo extends JpaRepository<Product, Integer>{

}
