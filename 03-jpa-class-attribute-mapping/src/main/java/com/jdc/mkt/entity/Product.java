package com.jdc.mkt.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Transient;

import lombok.Getter;
import lombok.Setter;

//@Entity
@Getter
@Setter
public class Product implements Serializable{

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(generator = "prod_seq")
	@SequenceGenerator(name = "prod_seq")
	private int id;
	@Column(
			columnDefinition = "varchar(45) not null check(char_length(name) >= 4)")
	private String name;
	private int price;
	@ManyToOne
	private Category category;
	@Transient
	private int count;
	
	
}
