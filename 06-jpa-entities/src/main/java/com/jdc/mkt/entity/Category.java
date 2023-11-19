package com.jdc.mkt.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
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
@Entity
@Table(name = "category_tbl")
@NoArgsConstructor
@RequiredArgsConstructor
//@EntityListeners(TimesListener.class)
public class Category implements Serializable,TimesOperator{

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(unique = true,nullable = false)
	@NonNull
	private String name;
	@Column(columnDefinition = "tinyint(1) default 1",nullable = false)
	private boolean active;
	@OneToMany(mappedBy = "category",orphanRemoval = true)
	private List<Item> items;
	
	private Times times;
	
}
