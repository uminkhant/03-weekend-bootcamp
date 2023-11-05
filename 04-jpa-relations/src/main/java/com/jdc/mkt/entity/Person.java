package com.jdc.mkt.entity;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Person  implements Serializable{

	private static final long serialVersionUID = 1L;
	private String name;
	private int age;
}
