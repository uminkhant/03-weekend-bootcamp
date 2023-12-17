package com.jdc.mkt.test;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import com.jdc.mkt.ApplicationConfig;
import com.jdc.mkt.repo.MemberRepo;
import com.jdc.mkt.repo.ProductRepo;

@SpringJUnitConfig(classes = ApplicationConfig.class)
@TestMethodOrder(OrderAnnotation.class)
public abstract class FactoryTest {

	@Autowired
	ProductRepo productRepo;
	
	@Autowired
	MemberRepo memberRepo;
}
