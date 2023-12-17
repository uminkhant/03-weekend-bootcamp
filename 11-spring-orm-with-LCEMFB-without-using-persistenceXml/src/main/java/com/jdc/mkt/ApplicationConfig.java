package com.jdc.mkt;

import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import jakarta.persistence.EntityManagerFactory;

@Configuration
@EnableTransactionManagement
@ComponentScan(basePackages = "com.jdc.mkt.repo")
@PropertySource("/database.properties")
public class ApplicationConfig {

//	@Bean
//	DataSource dataSource(
//			@Value("${db.url}")String url,
//			@Value("${db.user}")String user,
//			@Value("${db.pass}")String pass) {
//		var config = new BoneCPConfig();
//		config.setJdbcUrl(url);
//		config.setUser(user);
//		config.setPassword(pass);
//		return new BoneCPDataSource(config);
//	}
	
	@Bean
	DataSource dataSource() {
		var emb = new EmbeddedDatabaseBuilder();
		emb.setType(EmbeddedDatabaseType.HSQL);
		
		return emb.build();
	}
	
	@Bean
	LocalContainerEntityManagerFactoryBean entityManagerFactory(DataSource dataSource) {
		var bean = new LocalContainerEntityManagerFactoryBean();
		bean.setDataSource(dataSource);
		bean.setPackagesToScan("com.jdc.mkt.entity");
		bean.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
		bean.setJpaProperties(jpaProperties());
		return bean;
	}
	
	@Bean
	JpaTransactionManager transaction(EntityManagerFactory emf) {
		return new JpaTransactionManager(emf);
	}

	private Properties jpaProperties() {
		var prop = new Properties();
		prop.setProperty("hibernate.hbm2ddl.auto", "drop-and-create");
		prop.setProperty("hibernate.show_sql", "true");
		prop.setProperty("hibernate.format_sql", "true");
		return prop;
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
