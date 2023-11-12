package com.jdc.mkt.entity;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Register implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@EmbeddedId
	private RegisterPk id;
	
	private LocalDate date;
	private int fees;
	
	@MapsId("studentId")
	@ManyToOne
	private Student student;
	@MapsId("parentId")
	@ManyToOne
	private Parent parent;
	@MapsId("accountId")
	@ManyToOne
	private Account account;
	
}
