package com.jdc.mkt.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.JdbcTemplate;

import com.jolbox.bonecp.BoneCPConfig;
import com.jolbox.bonecp.BoneCPDataSource;

@Configuration
@PropertySource({"/database.properties","/sqlQuery.properties"})
@ComponentScan(basePackages = {"com.jdc.mkt.dao","com.jdc.mkt.factory"})
public class ApplicationConfig {
	
//	@Value("${db.url}")
//	private String url;
//	@Value("${db.user}")
//	private String username;
//	@Value("${db.pass}")
//	private String password;
	
	@Bean
	public DataSource dataSource(
			@Value("${db.url}") String url,
			@Value("${db.user}")String username,
			@Value("${db.pass}")String password) {
		
		var config = new BoneCPConfig();
		config.setJdbcUrl(url);
		config.setUsername(username);
		config.setPassword(password);
		
		return new BoneCPDataSource(config);
	}

	@Bean
	public JdbcOperations template(DataSource ds) {
		return new JdbcTemplate(ds,true);
	}
	
//	@Bean
//	public StudentDao dao(JdbcTemplate template) {
//		return new StudentDao(template);
//	}
}
