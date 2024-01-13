package com.jdc.mkt.entity;

import org.hibernate.annotations.ColumnDefault;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedNativeQuery;
import jakarta.persistence.NamedQuery;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@NamedQuery(
	name = "Customer.findAllByCityNam",
	query = "select c from Customer c where c.address.city = :city")

@NamedNativeQuery(
		name = "Customer.findByNativeCustomerTownshipId",
		resultClass = Customer.class,
		query = """
				select * from customer c where c.address_id = ?
				""")


public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@NonNull
	@Column(nullable = false,length = 45)
	private String name;
	@Column(nullable = false,unique = true,length = 12)
	private String phone;
	private String email;
	@ColumnDefault("true")
	private boolean active;
	@ManyToOne
	private Address address;
}
