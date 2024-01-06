package com.jdc.mkt.entity;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.EqualsAndHashCode;

@Embeddable
@EqualsAndHashCode
public class SaleDetilsPk implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Column(name = "product_id")
	private int productId;
	@Column(name = "sales_id")
	private int salesId;
}
