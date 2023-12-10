package com.jdc.mkt.test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.sql.ResultSet;
import java.sql.Types;
import java.util.List;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.PreparedStatementCreatorFactory;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import com.jdc.mkt.ApplicationConfig;
import com.jdc.mkt.dto.Member;

//@SpringJUnitConfig(locations = "/application-config.xml")
@SpringJUnitConfig(classes = ApplicationConfig.class)
@TestMethodOrder(OrderAnnotation.class)
public class MemberTest {

	@Autowired
	JdbcOperations operations;
	
	@Test
	@Order(1)
	@Sql("/tableMember.sql")
	void insertMember() {
		var result = operations.update("insert into member_tbl values (?,?,?)",
					"admin","andrew","admin12"
					);
		assertEquals(1, result);
	}
	
	@Test
	@Order(2)
	void selectMember() {
		var list = operations.queryForList("select m.name from member_tbl m where name=?",String.class,"william smith");
		assertEquals(1, list.size());
		
		var list1 = operations.queryForList("select * from member_tbl where name=? and loginId=?", "andrew","admin");
		assertEquals(1, list1.size());
		
		var map1 = operations.queryForMap("select *  from member_tbl where name=?","andrew");
		assertAll(
				()->assertTrue(map1.containsKey("loginId")),
				()->assertTrue(map1.containsKey("name")),
				()->assertTrue(map1.containsKey("password")),
				()->assertEquals("admin", map1.get("loginId")));
	
		
		var count = operations.queryForObject("select count(*) from member_tbl", Long.class);
		assertEquals(4, count);
		
		var rs = operations.queryForRowSet("select * from member_tbl where name=?","andrew");
		
		while(rs.next()) {
			System.out.println(rs.getString("name"));
		}
	}
	
	@Test
	@Order(3)
	void test2(
			@Qualifier("selectAllMember") PreparedStatementCreatorFactory factory,
			@Autowired RowMapper<Member>mapper) {
		var creator = factory.newPreparedStatementCreator(List.of());
		var stream1 = operations.queryForStream(creator,new BeanPropertyRowMapper<>(Member.class));
		
		stream1.forEach(a ->System.out.println(a.getName()));
	}
	
	
}



