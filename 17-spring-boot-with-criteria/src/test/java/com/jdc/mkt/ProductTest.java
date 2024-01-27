package com.jdc.mkt;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.jdc.mkt.entity.Product;
import com.jdc.mkt.service.ProductService;

@SpringBootTest
public class ProductTest {

	@Autowired
	ProductService service;

	@Test
	void selectProductByCategoryName() {
		var hList = service.selectProductByCategoryNameWithHibernateJpa("Fruits");
		show(hList);
		var sList = service.selectProductByCategoryNameWithSpec("Fruits");
		show(sList);
	}

	private void show(List<Product> hList) {
		for (Product p : hList) {
			System.out.printf("Name :%s%n", p.getName());
		}
		System.out.println();
	}
}
