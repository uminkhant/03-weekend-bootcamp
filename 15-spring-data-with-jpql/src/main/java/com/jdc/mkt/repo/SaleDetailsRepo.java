package com.jdc.mkt.repo;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.jdc.mkt.dto.SelectProductNamePriceQtyAndTotalByCategoryName;
import com.jdc.mkt.entity.SaleDetails;
import com.jdc.mkt.interDto.SelectProductNamePriceQtyAndTotalByDateInt;

public interface SaleDetailsRepo extends JpaRepository<SaleDetails, Integer> {

	@Query("""
			select sd.product product,sum(sd.qty) qty,sum(sd.total) total
			from SaleDetails sd where sd.sales.saleDate = :date group by sd.product.name,sd.product.dtPrice
			order by sd.product.dtPrice asc
			""")
	List<SelectProductNamePriceQtyAndTotalByDateInt> findProductNamePriceQtyAndTotalByDateWitInt(
			@Param("date") LocalDate date);

	// classs base projections with native query
	@Query(nativeQuery = true)
	List<SelectProductNamePriceQtyAndTotalByCategoryName> selectProductNamePrceQtyTotalByCategory(String name);
}
