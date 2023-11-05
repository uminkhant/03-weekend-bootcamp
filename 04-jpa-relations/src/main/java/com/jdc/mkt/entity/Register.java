package com.jdc.mkt.entity;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Register implements Serializable{

	private static final long serialVersionUID = 1L;
	@EmbeddedId
	private RegisterPk registerId;
//	@Id
//	private String StudentId;
//	private String classRoomId;
	private int fees;
	private LocalDate register_date;
}
