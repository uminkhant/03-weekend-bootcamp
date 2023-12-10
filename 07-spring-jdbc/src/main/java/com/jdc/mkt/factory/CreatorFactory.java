package com.jdc.mkt.factory;

import java.sql.Types;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.PreparedStatementCreatorFactory;

@Configuration
public class CreatorFactory {

	@Bean
	@Qualifier("studentNameLikeSearch")
	public PreparedStatementCreatorFactory studentNameLikeSearch(@Value("${student.name.like}") String sql) {
		return new PreparedStatementCreatorFactory(sql,Types.VARCHAR);
		
	}
	
	@Bean
	@Qualifier("studentInsert")
	public PreparedStatementCreatorFactory studentInsert(@Value("${student.insert}") String sql) {
		return new PreparedStatementCreatorFactory(sql,Types.VARCHAR,Types.INTEGER,Types.DATE);
	}
}
