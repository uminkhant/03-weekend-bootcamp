package com.jdc.mkt;

import org.hibernate.jpa.HibernatePersistenceProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalEntityManagerFactoryBean;
import org.springframework.transaction.TransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import jakarta.persistence.EntityManagerFactory;

@Configuration
@EnableTransactionManagement
@ComponentScan(basePackages = "com.jdc.mkt.repo")
public class ApplicationConfig {

	
	
	@Bean
	LocalEntityManagerFactoryBean entityManagerFactory() {
		var factory = new LocalEntityManagerFactoryBean();
		factory.setPersistenceProviderClass(HibernatePersistenceProvider.class);
		return factory;
	}
	
	@Bean
	TransactionManager transactionManager(EntityManagerFactory emf) {
		return new JpaTransactionManager(emf);
	}
}
