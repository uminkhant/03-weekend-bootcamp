package com.jdc.mkt.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.PreparedStatementCreatorFactory;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import com.jdc.mkt.config.ApplicationConfig;
import com.jdc.mkt.dto.Student;

@SpringJUnitConfig(classes = ApplicationConfig.class)
@TestMethodOrder(OrderAnnotation.class)
public class queryTest {

	@Autowired
	JdbcOperations operations;
	@Autowired
	RowMapper<Student> rowmapper;

	@Test
	@DisplayName("01-query with resultsetExtractor and preparedstatementcreator")
	@Order(1)
	void test1(@Qualifier("studentNameLikeSearch") PreparedStatementCreatorFactory factory) {
		var creator = factory.newPreparedStatementCreator(List.of("a%"));
		var list = new ArrayList<>();
		operations.query(creator, rs -> {

			while (rs.next()) {
				var s = new Student();
				s.setName(rs.getString(1));
				s.setAge(rs.getInt(2));
				s.setDob(rs.getDate(3).toLocalDate());
				list.add(s);
			}
			return list;
		});
		assertEquals(1, list.size());
	}

	@Test
	@DisplayName("02-query with preparedstatementcreator and rowcallbackhandler")
	@Order(2)
	void test2(@Qualifier("studentNameLikeSearch") PreparedStatementCreatorFactory factory) {
		var creator = factory.newPreparedStatementCreator(List.of("a%"));
		var list = new ArrayList<>();
		var stu = operations.query(creator, rch -> {

			while (rch.next()) {
				var s = new Student();
				s.setName(rch.getString(1));
				s.setAge(rch.getInt(2));
				s.setDob(rch.getDate(3).toLocalDate());
				return s;
			}
			return null;
		});
		list.add(stu);

	}

	@Test
	@DisplayName("02-query with update")
	@Order(3)
	@Sql(scripts = "/createTableStudent.sql")
	void test3(@Qualifier("studentInsert") PreparedStatementCreatorFactory factory) {
		var creator = factory.newPreparedStatementCreator(List.of("Andrew", 20, LocalDate.now()));
		operations.update(creator);
	}

	@Test
	@DisplayName("02-query with preparedstatementcreator and rowMapper")
	@Order(4)
	void test4(@Qualifier("studentNameLikeSearch") PreparedStatementCreatorFactory factory) {
		var creator = factory.newPreparedStatementCreator(List.of("a%"));
		
		var list = operations.query(creator,rowmapper);
		
		assertEquals(1, list.size());
	}
	
	@Test
	@DisplayName("05-query with preparedstatementcreator and rowcallbackhandler")
	@Order(5)
	void test5() {
		var list = operations.query("select * from student_tbl", rowmapper);
		list.forEach(s -> System.out.println(s.getName()));

	}

}
