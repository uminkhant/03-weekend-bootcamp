package com.jdc.mkt.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "parent_tbl")
public class Parent implements Serializable{

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@NonNull
	@Column(nullable = false,length = 45)
	private String name;
	@Enumerated(EnumType.STRING)
	private Gender gender;
	@ManyToMany
	private List<Student> students;
	@OneToOne
//	@JoinTable(name = "parent_contact_tbl", 
//	joinColumns = @JoinColumn(name = "parent_id", referencedColumnName = "id"),
//	inverseJoinColumns = @JoinColumn(name = "contact_id", referencedColumnName = "id"))
	@PrimaryKeyJoinColumn
	private Contact contact;
}
