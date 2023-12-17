package com.jdc.mkt;

import javax.sql.DataSource;

import org.hibernate.jpa.HibernatePersistenceProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.TransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import jakarta.persistence.EntityManagerFactory;


@Configuration
@EnableTransactionManagement
@ComponentScan(basePackages = "com.jdc.mkt.repo")
@PropertySource("/database.properties")
public class ApplicationConfig {
	

	@Bean
	LocalContainerEntityManagerFactoryBean entityManagerFactory() {
		var factory = new LocalContainerEntityManagerFactoryBean();
		factory.setPersistenceProviderClass(HibernatePersistenceProvider.class);
		return factory;
	}
	

	@Bean
	TransactionManager transactionManager(EntityManagerFactory emf) {
		return new JpaTransactionManager(emf);
	}
}
