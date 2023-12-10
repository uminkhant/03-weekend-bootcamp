package com.jdc.mkt.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.PreparedStatementCreatorFactory;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import com.jdc.mkt.config.ApplicationConfig;
import com.jdc.mkt.dao.StudentDao;
import com.jdc.mkt.dto.Student;

//@SpringJUnitConfig(locations = "/spring-config.xml")
@SpringJUnitConfig(classes = ApplicationConfig.class)
@TestMethodOrder(OrderAnnotation.class)
public class StudentTest {

	@Autowired
	StudentDao dao;

	@Autowired
	JdbcOperations operations;

	@Test
	@DisplayName("01-test with xml config and java config")
	@Sql("/createTableStudent.sql")
	@Order(1)
	void test1() {
		var st = new Student();
		st.setName("Aung Aung");
		st.setAge(25);
		st.setDob(LocalDate.of(1999, 03, 11));
		var row = dao.insertStudent(st);
		assertEquals(1, row);
	}

	@Test
	@DisplayName("02-test execute with preparedStatement")
	@Order(2)
	void test2() {
		var result = operations.execute("select * from student_tbl", (PreparedStatement stmt) -> {
			var rs = stmt.executeQuery();
			List<Student> list = new ArrayList<>();
			while (rs.next()) {
				var s = new Student();
				s.setName(rs.getString(1));
				s.setAge(rs.getInt(2));
				s.setDob(rs.getDate(3).toLocalDate());
				list.add(s);
			}
			return list;
		});
		assertEquals(1, result.size());
	}

	@Test
	@DisplayName("03-test execute with preparedStatement and preparedStatementCreator")
	@Order(3)
	void test3() {

		var factory = new PreparedStatementCreatorFactory("select * from student_tbl ");
		var creator = factory.newPreparedStatementCreator(List.of());

		var result = operations.execute(creator, (PreparedStatement stmt) -> {
			var rs = stmt.executeQuery();
			List<Student> list = new ArrayList<>();
			while (rs.next()) {
				var s = new Student();
				s.setName(rs.getString(1));
				s.setAge(rs.getInt(2));
				s.setDob(rs.getDate(3).toLocalDate());
				list.add(s);
			}
			return list;
		});
		assertEquals(1, result.size());
	}

	@Test
	@DisplayName("04-test execute with connectioncallback")
	@Order(4)
	void test4() {
		var result = operations.execute((Connection con) -> {
			var stmt = con.prepareStatement("insert into student_tbl values (?,?,?)");
			stmt.setString(1, "Su Su");
			stmt.setInt(2, 30);
			stmt.setDate(3, Date.valueOf(LocalDate.now()));
			return stmt.executeUpdate();
			
		});
		assertEquals(1, result);
	}
	
	@Test
	@DisplayName("05-test execute with StatementCallback")
	@Order(5)
	void test5() {
		var result = operations.execute((Statement stmt) -> {
			return stmt.executeUpdate("insert into student_tbl values ('sandar',22,'1999-03-11')");
			
		});
		assertEquals(1, result);
	}

}
