package com.jdc.mkt.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@RequiredArgsConstructor
public class Hotel {

	private int id;
	@NonNull
	private String name;
	private int numRooms;
	private Contact contact;
	private Address address;
	private boolean active;
}
