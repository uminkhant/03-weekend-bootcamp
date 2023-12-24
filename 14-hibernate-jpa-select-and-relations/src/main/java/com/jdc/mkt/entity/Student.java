
package com.jdc.mkt.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(nullable = false)
	private String name;
	private Gender gender;
	private String email;
	private String contact;
	@Column(columnDefinition = "tinyInt(1) default 1")
	private boolean active;
	
	public enum Gender{
		MALE,FEMALE,OTEHR
	}
}
