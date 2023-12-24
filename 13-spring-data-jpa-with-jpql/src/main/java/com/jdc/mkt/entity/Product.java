package com.jdc.mkt.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedNativeQueries;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@RequiredArgsConstructor
@Table(name = "product_tbl")
@NamedQueries({ 
		@NamedQuery(name = "Product.selectProductCount",query = "select count(p) from Product p"),
		@NamedQuery(name = "Product.selectProductByNameLike", query = "select p from Product p where lower(p.name) like lower(?1)"),
		@NamedQuery(name = "Product.selectProductByCatName", query = "select p from Product p where p.category.name = :category") })
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@NonNull
	private String name;
	@Column(columnDefinition = "varchar(10) default 'MEDIUM'")
	@Enumerated(EnumType.STRING)
	private Size size;
	@NonNull
	private Double price;
	@NonNull
	@ManyToOne
	private Category category;
	@NonNull
	private LocalDate createDate;

	public enum Size {
		SMALL, MEDIUM, LARGE
	}
}
