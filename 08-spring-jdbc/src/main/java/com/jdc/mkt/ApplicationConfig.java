package com.jdc.mkt;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;

import com.jolbox.bonecp.BoneCPConfig;
import com.jolbox.bonecp.BoneCPDataSource;

@Configuration
@PropertySource("/database.properties")
@ComponentScan(basePackages = "com.jdc.mkt.factory")
public class ApplicationConfig {

	@Bean
	public DataSource dataSource(
			@Value("${db.url}")String url,
			@Value("${db.user}")String user,
			@Value("${db.pass}")String pass) {
		
		var config = new BoneCPConfig();
		config.setJdbcUrl(url);
		config.setUsername(user);
		config.setPassword(pass);
		return new BoneCPDataSource(config);
	}
	
	@Bean
	public JdbcOperations template(DataSource dataSource) {
		return new JdbcTemplate(dataSource,true);
	}
	
	@Bean
	public SimpleJdbcInsert insert(DataSource dataSource) {
		var ds = new SimpleJdbcInsert(dataSource);
		ds.setTableName("student_tbl");
		ds.setGeneratedKeyName("id");
		return ds;
	}
	
	@Bean
	public NamedParameterJdbcTemplate paramTemplate(DataSource dataSource) {
		return new NamedParameterJdbcTemplate(dataSource);
	}
}
