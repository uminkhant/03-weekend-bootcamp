package com.jdc.mkt.entity;

import java.time.LocalDate;
import java.util.List;

import org.hibernate.annotations.ColumnDefault;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Entity
@Data
public class Sales {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@ColumnDefault("true")
	private boolean active;
	@ManyToOne
	private Customer customer;
	@Column(name="sale_date")
	private LocalDate saleDate;
	@OneToMany(mappedBy = "sales")
	private List<SaleDetails>saleDetails;
}
