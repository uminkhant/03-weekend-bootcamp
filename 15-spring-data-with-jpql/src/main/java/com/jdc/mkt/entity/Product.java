package com.jdc.mkt.entity;

import org.hibernate.annotations.ColumnDefault;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQuery;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@NamedQuery(
	name="Product.findByCategoryAndDtPrice",
	query = "select p from Product p where p.category.name = :category and p.dtPrice between :low and :high")
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(nullable = false,length = 45,unique = true)
	private String name;
	@Column(name="dt_price")
	private int dtPrice;
	@Column(name="ws_price")
	private int wsPrice;
	@ColumnDefault("true")
	private boolean active;
	@ManyToOne
	private Category category;
}
