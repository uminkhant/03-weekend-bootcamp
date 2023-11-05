package com.jdc.mkt.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
//@Entity
public class Category implements Serializable{

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(generator = "prod_seq")
	private int id;
	@Column(nullable = false,unique = true,length = 30)
	private String name;
	@Column(columnDefinition = "tinyint(1) not null default 1")
	private boolean active;
}
