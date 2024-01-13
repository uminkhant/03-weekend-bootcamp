package com.jdc.mkt.repo;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.jdc.mkt.dto.SelectProductAndQtys;
import com.jdc.mkt.dto.SelectProductNamePriceQtyAndTotalByCategoryName;
import com.jdc.mkt.dto.SelectProductNamePriceQtyAndTotalByDate;
import com.jdc.mkt.entity.Sales;

public interface SalesRepo extends JpaRepository<Sales, Integer>{

	//class base projections
	@Query("""
			select new com.jdc.mkt.dto.SelectProductAndQtys(sd.product.name,sd.product.dtPrice,sd.qty)
			from Sales s join SaleDetails sd on s.id = sd.id.salesId
			where s.customer.name = :name order by sd.product.name asc
			""")
	List<SelectProductAndQtys> findProductAndQtysByCustomer(@Param("name") String name);
	
	@Query("""
			select new com.jdc.mkt.dto.SelectProductNamePriceQtyAndTotalByDate(
			sd.product.name,sd.product.dtPrice,sum(sd.qty),sum(sd.total))
			from SaleDetails sd where sd.sales.saleDate = :date
			 group by sd.product.name,sd.product.dtPrice
			order by sd.product.dtPrice asc
			""")
	List<SelectProductNamePriceQtyAndTotalByDate> findProductNamePriceQtyAndTotalByDate(@Param("date") LocalDate date);
	
	//interface base projections
	@Query("""
			select sd.product.name productName,sd.product.dtPrice productPrice,sum(sd.qty) qty,sum(sd.total) total
			from SaleDetails sd where sd.sales.saleDate = :date 
			group by sd.product.name,sd.product.dtPrice
			order by sd.product.dtPrice asc
			""")
	List<SelectProductNamePriceQtyAndTotal> findProductNamePriceQtyAndTotalByDateWithDtoInt(@Param("date") LocalDate date);
	
	
}
