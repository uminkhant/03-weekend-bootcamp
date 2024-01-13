package com.jdc.mkt.entity;

import org.hibernate.annotations.ColumnDefault;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(nullable = false,length = 45,unique = true)
	private String name;
	@Column(name="dt_price")
	private Integer dtPrice;
	@Column(name="ws_price")
	private Integer wsPrice;
	@ColumnDefault("true")
	private boolean active;
	@ManyToOne
	private Category category;
}
