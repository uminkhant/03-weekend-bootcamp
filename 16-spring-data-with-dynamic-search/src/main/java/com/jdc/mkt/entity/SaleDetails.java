package com.jdc.mkt.entity;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "sale_details")
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
