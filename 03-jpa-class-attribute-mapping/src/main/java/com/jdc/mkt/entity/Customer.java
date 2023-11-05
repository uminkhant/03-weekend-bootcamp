package com.jdc.mkt.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.SecondaryTable;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import lombok.Getter;
import lombok.Setter;
import javax.persistence.Enumerated;
import static javax.persistence.EnumType.STRING;

@Getter
@Setter
@Entity
@Table(
name = "customer_tbl",
indexes = {
		@Index(columnList = "name")
},
uniqueConstraints = {
		@UniqueConstraint(columnNames = "name")
})
@SecondaryTable(name = "contact_tbl")
//@SecondaryTables(value = {
//		@SecondaryTable(name = ""),
//		@SecondaryTable(name = ""),
//})
public class Customer implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int id;
	private String name;
	private Address address;
	@Column(table = "contact_tbl")
	private String email;
	@Column(table = "contact_tbl")
	private String primaryContact;
	@Column(table = "contact_tbl")
	private String secondaryContact;
	
	@Enumerated(STRING)
	@Column(columnDefinition = "varchar(45) not null default 'NOTMEMBER' ")
	private Member member;
	
	enum Member{
		NOTMEMBER,SILVER,GOLD,DIAMOND
	}
	
}
