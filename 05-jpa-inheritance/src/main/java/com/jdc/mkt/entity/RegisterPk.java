package com.jdc.mkt.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Embeddable
@EqualsAndHashCode
public class RegisterPk implements Serializable {

	private static final long serialVersionUID = 1L;
	@Column(name ="parent_id")
	private int parentId;
	@Column(name="account_id")
	private int accountId;
	@Column(name ="student_id")
	private int studentId;
}
