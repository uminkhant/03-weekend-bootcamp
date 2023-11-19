package com.jdc.mkt.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import static javax.persistence.FetchType.EAGER;

@Getter
@Setter
@Entity
@NoArgsConstructor
@RequiredArgsConstructor
public class ItemSize {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@NonNull
	private String name;
	@ManyToMany
	private List<Item>items;
	
	{
		items = new ArrayList<Item>();
	}
	
	public void addItem(Item item) {	
		items.add(item);
	}
}
