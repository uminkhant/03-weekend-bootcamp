package com.jdc.mkt.entity;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "parent_tbl")
@DiscriminatorValue("P")
public class Parent extends Account {

	private static final long serialVersionUID = 1L;
	
	@AttributeOverrides({
		@AttributeOverride(column = @Column(name ="primary_email"),name = "email"),
		@AttributeOverride(column = @Column(name = "primary_phone"),name = "phone")})
	private Contact primaryContact;
	@AttributeOverrides({
		@AttributeOverride(column = @Column(name ="secondary_email"),name = "email"),
		@AttributeOverride(column = @Column(name = "secondary_phone"),name = "phone")})
	private Contact secondaryontact;
	@OneToOne
	private Address address;
	
}
