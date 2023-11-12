package com.jdc.mkt.entity;

import static javax.persistence.TemporalType.TIME;

import java.util.Date;

import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;

import lombok.Getter;
import lombok.Setter;

//@Entity
@Getter
@Setter
@IdClass(ProductDetailsPk.class)
public class ProductDetails {

	//@EmbeddedId
	//private ProductDetailsPk id;
	@Id
	private int productId;
	@Id
	private int cutomerId;
	@ManyToOne
	private Product product;
	private int qty;
	@Temporal(TIME)
	private Date date;
}
