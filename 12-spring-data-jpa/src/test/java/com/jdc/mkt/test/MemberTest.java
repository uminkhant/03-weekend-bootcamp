package com.jdc.mkt.test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import com.jdc.mkt.ApplicationConfig;
import com.jdc.mkt.entity.Member;
import com.jdc.mkt.repo.MemberRepo;

@SpringJUnitConfig(classes = ApplicationConfig.class)
//@SpringJUnitConfig(locations = "/appConfig.xml")
@TestMethodOrder(OrderAnnotation.class)
public class MemberTest {

	@Autowired
	MemberRepo repo;
	
	@ParameterizedTest
	@CsvSource("Andrew,admin,123")
	
	@Order(1)
	void create(String name,String loginId,String password) {
		var m = repo.save(new Member(name,loginId,password));
		assertNotNull(m);
	}
	
	@ParameterizedTest
	@CsvSource("Sir.Andrew,admin,456")
	@Order(2)
	void update(String name,String loginId,String password) {
		
		var m = repo.findById(1).get();
		assertNotNull(m);
		m.setName(name);
		m.setLoginId(loginId);
		m.setPassword(password);
		m = repo.save(m);
		assertNotNull(m);
		
	}
	
	@Test
	@Sql(statements = {
			"insert into member_tbl(name,loginId,password) values ('aaa','aaa','111')",
			"insert into member_tbl(name,loginId,password) values ('bbb','bbb','222')",
			"insert into member_tbl(name,loginId,password) values ('ccc','ccc','333')",
			"insert into member_tbl(name,loginId,password) values ('ddd','ddd','444')",
			"insert into member_tbl(name,loginId,password) values ('eee','eee','555')"
		})
	@Order(3)
	void find() {
		var list = repo.findAll();
		assertEquals(6, list.size());
		
		var listWithIds =  repo.findAllById(List.of(4,5,6));
		assertEquals(3,listWithIds.size());
	}
	
	
}
