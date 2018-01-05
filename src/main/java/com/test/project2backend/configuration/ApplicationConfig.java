package com.test.project2backend.configuration;

import java.util.Properties;
import javax.sql.DataSource;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ComponentScan(basePackages = { "com.test" }, excludeFilters = {
		@Filter(type = FilterType.ANNOTATION, value = Configuration.class) })
@EnableTransactionManagement
public class ApplicationConfig {

	@Bean("dataSource")
	public DataSource getDataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("oracle.jdbc.driver.OracleDriver");
		dataSource.setUrl("jdbc:oracle:thin:@localhost:1521:xe");
		dataSource.setUsername("oracledb");
		dataSource.setPassword("oracledb");
		return dataSource;
	}
	@Bean
	public SessionFactory sessionFactory(DataSource dataSource) {
		LocalSessionFactoryBuilder localSessionFactoryBuilder = new LocalSessionFactoryBuilder(getDataSource());
		localSessionFactoryBuilder.scanPackages("com.test.project2backend.model");
		localSessionFactoryBuilder.addProperties(hibernateProperties());
		return localSessionFactoryBuilder.buildSessionFactory();
		// return localSessionFactoryBuilder;
	}
	
	public Properties hibernateProperties()
	{
		Properties properties=new Properties();
		properties.put("hibernate.dialect","org.hibernate.dialect.Oracle10gDialect");
		properties.put("hibernate.show_sql","true");
		properties.put("hibernate_format_sql","true");
		properties.put("hibernate.hbm2ddl.auto","update");
		return properties;
	}
	
	@Bean
	public HibernateTransactionManager transactionManager(SessionFactory sessionFactory)
	{
		HibernateTransactionManager hibernateTransactionManager=new HibernateTransactionManager(sessionFactory);
		return hibernateTransactionManager;	
	}
}
