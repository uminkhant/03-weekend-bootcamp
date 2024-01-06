package com.jdc.mkt.test;

import java.time.LocalDate;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import com.jdc.mkt.AppConfig;
import com.jdc.mkt.repo.SaleDetailsRepo;
import com.jdc.mkt.repo.SalesRepo;

@SpringJUnitConfig(classes = AppConfig.class)
public class SaleTest {

	@Autowired
	SalesRepo saleRepo;
	@Autowired
	SaleDetailsRepo detailsRepo;
	
	@Test
	@Disabled
	void findSaleProductAndQtyByCustomer() {
		var list = saleRepo.findProductAndQtysByCustomer("Andrew");
		System.out.println("Size :"+list.size());
		list.forEach(s -> System.out.println(s.name()+"\t"+s.price()));
	}
	
	@Test
	@Disabled
	void findProductNamePriceQtyAndTotalByDate() {
		var list = saleRepo.findProductNamePriceQtyAndTotalByDate(LocalDate.of(2023, 05, 12));
		System.out.println(list.size());
		list.forEach(p -> System.out.println(p.name()+"\t\t\t"+p.price()+"\t"+p.qty()+"\t"+p.total()));
	}
	
	@Test
	void findProductNamePriceQtyAndTotalByDateWithInt() {
		var list = detailsRepo.findProductNamePriceQtyAndTotalByDateWitInt(LocalDate.of(2023, 05, 12));
		System.out.println(list.size());
		list.forEach(p -> System.out.println(p.getProduct().getName()+"\t"+p.getProduct().getDtPrice()+"\t"+p.getQty()+"\t"+p.getTotal()));
	}
}
