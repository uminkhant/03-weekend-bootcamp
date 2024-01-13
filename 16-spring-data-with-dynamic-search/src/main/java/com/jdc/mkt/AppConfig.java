package com.jdc.mkt;

import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.jdc.mkt.custom.repo.BaseRepositoryImpl;
import com.jolbox.bonecp.BoneCPConfig;
import com.jolbox.bonecp.BoneCPDataSource;

import jakarta.persistence.EntityManagerFactory;

@Configuration
@EnableTransactionManagement
@ComponentScan(basePackages = "com.jdc.mkt.service")
@EnableJpaRepositories(
		basePackages = {
				"com.jdc.mkt.repo",
				"com.jdc.mkt.custom.repo"},
		repositoryImplementationPostfix = "Default",
		repositoryBaseClass = BaseRepositoryImpl.class)
@PropertySource("/dbConfig.properties")
public class AppConfig {

	@Bean
	DataSource dataSource(
			@Value("${db.url}") String url
			,@Value("${db.user}")String user
			,@Value("${db.pass}")String pass) {
		
		var ds = new BoneCPConfig();
		ds.setJdbcUrl(url);
		ds.setUser(user);
		ds.setPassword(pass);
		return new BoneCPDataSource(ds);
	}
	@Bean
	LocalContainerEntityManagerFactoryBean entityManagerFactory(DataSource ds) {
		var emf = new LocalContainerEntityManagerFactoryBean();
		emf.setPackagesToScan("com.jdc.mkt.entity");
		emf.setDataSource(ds);
		emf.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
		emf.setJpaProperties(jpaProperties());
		return emf;
	}

	@Bean
	JpaTransactionManager transactionManager(EntityManagerFactory emf) {
		return new JpaTransactionManager(emf);
	}
	
	private Properties jpaProperties() {
		var prop = new Properties();
		prop.put("hibernate.show_sql",true);
		prop.put("hibernate.format_sql",true);
		prop.put("hibernate.hbm2ddl.auto","create");
		prop.put("jakarta.persistence.sql-load-script-source","/insert.sql");
		return prop;
	}
}
