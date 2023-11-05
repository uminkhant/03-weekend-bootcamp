package com.jdc.mkt.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "contact_tbl")
public class Contact implements Serializable{

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String email;
	@Column(columnDefinition = "varchar(12) not null check(char_length(prmaryContact)>= 7)")
	private String prmaryContact;
	@Column(columnDefinition = "varchar(12) check(char_length(secondaryContact)>= 7)")
	private String secondaryContact;
}
