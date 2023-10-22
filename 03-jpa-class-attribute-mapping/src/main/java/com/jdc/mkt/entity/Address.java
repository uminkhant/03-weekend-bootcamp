package com.jdc.mkt.entity;

import java.io.Serializable;

import javax.persistence.Embeddable;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode
@Embeddable
public class Address implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private String street;
	private String township;
	private String city;
		
}
