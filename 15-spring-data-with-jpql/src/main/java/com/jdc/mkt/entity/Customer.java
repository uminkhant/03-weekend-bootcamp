package com.jdc.mkt.entity;

import org.hibernate.annotations.ColumnDefault;

import com.jdc.mkt.dto.SelectCustomerNameAndEmail;

import jakarta.persistence.Column;
import jakarta.persistence.ColumnResult;
import jakarta.persistence.ConstructorResult;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedNativeQuery;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.SqlResultSetMapping;
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

@SqlResultSetMapping(
		name = "selectNameAndEmail",
		classes = @ConstructorResult(
				targetClass =SelectCustomerNameAndEmail.class,
				columns = {
						@ColumnResult(name = "name"),
						@ColumnResult(name ="email"),
						@ColumnResult(name = "township")
				})
		)
@NamedNativeQuery(
		resultSetMapping = "selectNameAndEmail",
		name = "Customer.findNameAndEmailWithNativequery",
		query = """
				select c.name name ,c.email email,a.township township  from customer c
				join address a on c.address_id = a.id 
				where c.name like ?
				"""
	)
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
