package com.jdc.mkt.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.sql.SQLException;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import com.jdc.mkt.JDBCPreparedStatementDemo;
import com.jdc.mkt.JDBCStatementDemo;

@TestMethodOrder(OrderAnnotation.class)
public class DataTest {
	
	static JDBCStatementDemo demo ;
	static JDBCPreparedStatementDemo demo2;
	
	@BeforeAll
	static void init() {
		demo = new JDBCStatementDemo();
		demo2 = new JDBCPreparedStatementDemo();
	}

	@Test	
	@Order(1)
	void testData() throws SQLException {
		demo.truncatTest();
		var list = demo.selectData();
		assertEquals(2, list.size());	
		list.stream().forEach(System.out::println);
	}
	
	@ParameterizedTest
	@ValueSource(strings = {"Susan","Snow"})
	@Order(2)
	void testInsertwithStatement(String name) {
		var row = demo.insertData(name);
		assertEquals(1, row);
	}
	
	@ParameterizedTest
	@ValueSource(strings = {"John","William"})
	@Order(3)
	void testInsertWithPreparement(String name) {
		var row = demo2.insertData(name);
		assertEquals(1, row);
	}
	
}
