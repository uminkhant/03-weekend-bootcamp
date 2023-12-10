package com.jdc.mkt.dto;

import java.time.LocalDate;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Student {

	private String name;
	private int age;
	private LocalDate dob;
}
