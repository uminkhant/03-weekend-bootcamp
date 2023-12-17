package com.jdc.mkt;

import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import jakarta.persistence.EntityManagerFactory;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(entityManagerFactoryRef = "entityManagerFactoryBean")
public class ApplicationConfig {

	@Bean
	DataSource dataSource() {
		var ds = new EmbeddedDatabaseBuilder();
		ds.setType(EmbeddedDatabaseType.H2);
		return ds.build();
	}
	
	@Bean
	LocalContainerEntityManagerFactoryBean entityManagerFactoryBean(DataSource ds) {
		var bean = new LocalContainerEntityManagerFactoryBean();
		bean.setDataSource(ds);
		bean.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
		bean.setPackagesToScan("com.jdc.mkt.entity");
		bean.setJpaPropertyMap(jpaProperties());
		return bean;
	}
	
	@Bean
	JpaTransactionManager transactionManager(EntityManagerFactory emf) {
		return new JpaTransactionManager(emf);
	}

	private Map<String, String> jpaProperties() {
		Map<String,String> map = new HashMap<>();
		map.put("hibernate.hbm2ddl.auto", "create");
		map.put("hibernate.show_sql","true");
		map.put("hibernate.format_sql", "true");
		return map;
	}
	
	
	
	
	
	
	
	
	
	
	
}
