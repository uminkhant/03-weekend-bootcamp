package com.jdc.mkt.entity;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import javax.persistence.CollectionTable;
import javax.persistence.JoinColumn;
import javax.persistence.MapKeyColumn;
import javax.persistence.MapKeyEnumerated;
import javax.persistence.OrderBy;
import javax.persistence.OrderColumn;
import javax.persistence.Table;
import javax.persistence.Enumerated;
import static javax.persistence.EnumType.STRING;

@Entity
@Getter
@Setter
@NoArgsConstructor
@RequiredArgsConstructor
@Table(name = "student_tbl")
public class Student implements Serializable{

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@NonNull
	private String name;
	@ElementCollection
	@CollectionTable(name = "student_hobbies_tbl", 
	joinColumns = @JoinColumn(name = "student_id", referencedColumnName = "id"))
	//@OrderBy("hobbies asc")
	@OrderColumn(name = "hobby")
	@Enumerated(STRING)
	private List<Gender> hobbies;
	@ElementCollection
	@CollectionTable(name = "student_grade_tbl",
	joinColumns = @JoinColumn(name="student_id",referencedColumnName = "id") )
	@MapKeyEnumerated(STRING)
	@MapKeyColumn(name = "grade_type")
	//@OrderBy("grade_type asc")
	@OrderColumn(name = "hobby")
	private Map<Gender, String> grade ;
	@ElementCollection
	@CollectionTable(name = "student_register_tbl",
	joinColumns = @JoinColumn(name="student",referencedColumnName = "id") )
	//@OrderBy("student desc")
	@OrderColumn(name = "hobby")
	private Set<RegisterPk> register;
	//private Parent parentId;

}





