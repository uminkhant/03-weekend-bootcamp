package com.jdc.mkt.repo;

import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;

import com.jdc.mkt.entity.Product;

public interface ProductRepo extends JpaRepositoryImplementation<Product, Integer>{

}
