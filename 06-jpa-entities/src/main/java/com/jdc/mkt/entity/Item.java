package com.jdc.mkt.entity;

import static javax.persistence.CascadeType.DETACH;
import static javax.persistence.CascadeType.MERGE;
import static javax.persistence.CascadeType.PERSIST;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.jdc.mkt.entity.listner.Times;
import com.jdc.mkt.entity.listner.TimesListener;
import com.jdc.mkt.entity.listner.TimesOperator;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@RequiredArgsConstructor
@Entity
@Table(name = "item_tbl")
//@EntityListeners(TimesListener.class)
public class Item implements Serializable,TimesOperator{

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@NonNull
	private String name;
	@NonNull
	private Integer price;
	@Column(columnDefinition = "tinyint(1) default 1",nullable = false)
	private boolean active;
	@ManyToOne(cascade = { PERSIST, MERGE, DETACH })
	@NonNull
	private Category category;
	
	private Times times;
//	@ManyToMany(mappedBy = "items")
//	private List<ItemSize>sizes;
	
//	@PrePersist
//	void beforePersist() {
//		System.out.println("before persist item");
//	}
//	
//	@PostPersist
//	void afterPersist() {
//		System.out.println("after persist item");
//	}
//	
//	@PreUpdate
//	void beforeUpdate() {
//		System.out.println("before Update item");
//	}
//	
//	@PreRemove
//	void beforeRemove() {
//		System.out.println("before remove item");
//	}
//	
//	@PostLoad
//	void beforeFind() {
//		System.out.println("after find item");
//	}

	
}
