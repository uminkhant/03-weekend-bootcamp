package com.jdc.mkt.test;

import java.time.LocalDate;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import com.jdc.mkt.AppConfig;
import com.jdc.mkt.repo.SaleDetailsRepo;
import com.jdc.mkt.repo.SalesRepo;

import jakarta.transaction.Transactional;

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
	@Disabled
	void findProductNamePriceQtyAndTotalByDateWithInt() {
		var list = detailsRepo.findProductNamePriceQtyAndTotalByDateWitInt(LocalDate.of(2023, 05, 12));
		System.out.println(list.size());
		//list.forEach(p -> System.out.println(p.getProduct().getName()+"\t"+p.getProduct().getDtPrice()+"\t"+p.getQty()+"\t"+p.getTotal()));
	}
	
	@Test
	@Disabled
	void findProductNamePriceQtyAndTotalByDateWithDtoInt() {
		var list = saleRepo.findProductNamePriceQtyAndTotalByDateWithDtoInt(LocalDate.of(2023, 05, 12));
		list.forEach(sd -> System.out.println(
				sd.getProductName()+
				"\t"+sd.getProductPrice()+
				"\t"+sd.getQty()+
				"\t"+sd.getTotal()));
	}
	
	@Test
	void selectProductNamePrceQtyTotalByCategory() {
		var list = detailsRepo.selectProductNamePrceQtyTotalByCategory("Diary");
		System.out.println(list);
	}
}
