package com.jdc.mkt.entity;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@DiscriminatorValue("T")
public class Teacher extends Account{

	private static final long serialVersionUID = 1L;
	
	private String course;
	
}
