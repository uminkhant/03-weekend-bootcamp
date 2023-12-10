package com.jdc.mkt.factory;

import java.sql.Types;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.PreparedStatementCreatorFactory;

@Configuration
public class CreatorFactory {

	@Bean
	@Qualifier("selectAllMember")
	public PreparedStatementCreatorFactory selectAllMember() {
		return new PreparedStatementCreatorFactory("select * from member_tbl");
	}
	
	@Bean
	@Qualifier("createStudent")
	public PreparedStatementCreatorFactory createStudent() {
		var factory = new PreparedStatementCreatorFactory("insert into student_tbl(name,age) values (?,?)",Types.VARCHAR,Types.INTEGER);
		factory.setReturnGeneratedKeys(true);
		return factory;
	}
	
	
}
