package com.jdc.mkt.service;

public interface CrudOperation<T> {

	int insert(T t);
	int update(T t);
	int delete(T t);
	T select(T t);
}
