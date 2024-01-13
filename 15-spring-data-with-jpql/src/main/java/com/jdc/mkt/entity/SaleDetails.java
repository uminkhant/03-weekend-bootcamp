package com.jdc.mkt.entity;

import com.jdc.mkt.dto.SelectProductNamePriceQtyAndTotalByCategoryName;

import jakarta.persistence.ColumnResult;
import jakarta.persistence.ConstructorResult;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.NamedNativeQuery;
import jakarta.persistence.SqlResultSetMapping;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "sale_details")
@SqlResultSetMapping(
		name = "productNamepriceqtyBycat", 
		classes = @ConstructorResult(
				targetClass = SelectProductNamePriceQtyAndTotalByCategoryName.class,
				columns = {
		@ColumnResult(name = "name"), 
		@ColumnResult(name = "price"), 
		@ColumnResult(name = "qty",type = Long.class),
		@ColumnResult(name = "total",type = Long.class) 
		}))
@NamedNativeQuery(name = "SaleDetails.selectProductNamePrceQtyTotalByCategory", 
	resultSetMapping = "productNamepriceqtyBycat", 
	query = """
		select p.name name,p.dt_price price, sum(sd.qty) as qty, sum(sd.qty*p.dt_price) as total
		from sale_details sd
		join product p on sd.product_id = p.id
		join category c on p.category_id = c.id 
		where c.name = 'Diary' group by p.name,p.dt_price
		""")
public class SaleDetails {

	@EmbeddedId
	private SaleDetilsPk id;
	private int qty;
	private int total;
	@ManyToOne
	@MapsId("productId")
	private Product product;
	@ManyToOne
	@MapsId("salesId")
	private Sales sales;
}
