package com.proje.person.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.proje.person.DAO.ImpPersonDAO;
import com.proje.person.DAO.PersonDAO;
import com.proje.person.model.Person;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.proje.person")

public class SpringMvcConfig implements WebMvcConfigurer{

	@Bean
	public DataSource getDataSource()
	{
		DriverManagerDataSource dataSource=new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/mavidev_example");
		dataSource.setUsername("root");
		dataSource.setPassword("");
		
		
		return dataSource;	
		
		
	}
	@Bean
	public ViewResolver viewResolver() {
		InternalResourceViewResolver resolver= new InternalResourceViewResolver();
		resolver.setPrefix("/WEB-INF/views/");
		resolver.setSuffix(".jsp");
		
		
		
		return resolver;
	}
	@Bean
	public PersonDAO getPersonDAO() {
		
		return new ImpPersonDAO(getDataSource());
		
		
		
		
	
	}

}
