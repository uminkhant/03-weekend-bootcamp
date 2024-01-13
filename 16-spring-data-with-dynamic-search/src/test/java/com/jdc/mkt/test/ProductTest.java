package com.jdc.mkt.test;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import com.jdc.mkt.AppConfig;
import com.jdc.mkt.repo.ProductRepo;

@SpringJUnitConfig(classes = AppConfig.class)
public class ProductTest {

	@Autowired
	ProductRepo repo;
	
	@ParameterizedTest
	@CsvSource({
		",,,",
		"Diary,Milk,,",
		"Diary,Milk,1000,3000"})
	void testSearch(String cName,String pName,Integer sPrice,Integer ePrice) {
		var list = repo.search(cName, pName, sPrice, ePrice);
		list.forEach(p ->System.out.println(
				p.getCategory().getName()+
				"\t"+ p.getName()+
				"\t"+p.getDtPrice()));
		System.out.println("=============================================");
		
	}
}
