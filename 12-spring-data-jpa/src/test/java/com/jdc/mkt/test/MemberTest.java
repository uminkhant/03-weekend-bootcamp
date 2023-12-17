package com.jdc.mkt.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.test.context.jdbc.Sql;

import com.jdc.mkt.entity.Member;
public class MemberTest extends FactoryTest{	
	
	@ParameterizedTest
	@CsvSource("Andrew,admin,123")	
	@Order(1)
	void create(String name,String loginId,String password) {
		var m = memberRepo.save(new Member(name,loginId,password));
		assertNotNull(m);
		var list = memberRepo.saveAll(List.of(
				new Member("hh", "hh", "888"),
				new Member("iii","iii","999")
				));
		assertEquals(2, list.size());
	}
	
	@ParameterizedTest
	@CsvSource("Sir.Andrew,admin,456")
	@Order(2)
	void update(String name,String loginId,String password) {
		
		var m = memberRepo.findById(1).get();
		assertNotNull(m);
		m.setName(name);
		m.setLoginId(loginId);
		m.setPassword(password);
		m = memberRepo.save(m);
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
		var list = memberRepo.findAll();
		assertEquals(8, list.size());
		
		var listWithIds =  memberRepo.findAllById(List.of(4,5,6));
		assertEquals(3,listWithIds.size());
	}
	
	@Test
	@Order(4)
	void delete() {
		var m1 = new Member("aaa","aaa","111");
		m1.setId(3);
		memberRepo.delete(m1);
		assertEquals(7, memberRepo.findAll().size());
		
		memberRepo.deleteById(4);
		assertEquals(6, memberRepo.findAll().size());
		
		memberRepo.deleteAllById(List.of(6,7));
		assertEquals(4, memberRepo.findAll().size());
		
		memberRepo.deleteAll();
		assertEquals(0, memberRepo.findAll().size());
	}
	
}
