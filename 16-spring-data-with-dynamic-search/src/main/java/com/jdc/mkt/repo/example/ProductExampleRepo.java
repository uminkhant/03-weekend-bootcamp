package com.jdc.mkt.repo.example;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jdc.mkt.entity.Product;

public interface ProductExampleRepo  extends JpaRepository<Product, Integer>{

}
