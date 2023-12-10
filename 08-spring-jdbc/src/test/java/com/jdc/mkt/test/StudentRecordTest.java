package com.jdc.mkt.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.DataClassRowMapper;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.PreparedStatementCreatorFactory;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import com.jdc.mkt.ApplicationConfig;
import com.jdc.mkt.dto.Member;
import com.jdc.mkt.dto.StudentRecord;

@SpringJUnitConfig(classes = ApplicationConfig.class)
@TestMethodOrder(OrderAnnotation.class)
public class StudentRecordTest {

	@Autowired
	JdbcOperations operations;
	@Autowired
	SimpleJdbcInsert insert;
	@Autowired
	NamedParameterJdbcTemplate template;
	
	
	@Test
	@Sql("/tableStudent.sql")
	@Order(1)
	void createTest(@Qualifier("createStudent")PreparedStatementCreatorFactory factory) {
		var creator = factory.newPreparedStatementCreator(List.of("Aung Aung",23));
		var holder = new GeneratedKeyHolder();
		 operations.update(creator, holder);
		assertEquals(4, holder.getKey().intValue());
		
	}

	@Test
	@Order(2)
	void test1() {
		var listStu = operations.query("select * from student_tbl", new DataClassRowMapper<>(StudentRecord.class));
		assertEquals(4, listStu.size());
		var listMem = operations.query("select * from member_tbl", new DataClassRowMapper<>(Member.class));
		assertEquals(4, listMem.size());
	}
	
	@Test
	@Order(3)
	void testFindById() {
		var student = template.queryForObject(
				"select * from student_tbl where id = :id",
				Map.of("id", 4), 
				new DataClassRowMapper<>(StudentRecord.class));
		assertNotNull(student);
	}
	
	
	
	
	
	
	
}
