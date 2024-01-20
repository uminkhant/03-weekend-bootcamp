package com.jdc.mkt.entity;

import jakarta.persistence.metamodel.SingularAttribute;

//@StaticMetamodel(Address.class)
public class Address_test {

	public static volatile SingularAttribute<Address, Integer> id;
	public static volatile SingularAttribute<Address, String> city;
	public static volatile SingularAttribute<Address, String> township;
	public static volatile SingularAttribute<Address, String> street;
}
