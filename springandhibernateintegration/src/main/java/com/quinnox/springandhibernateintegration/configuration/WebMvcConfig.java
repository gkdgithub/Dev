package com.quinnox.springandhibernateintegration.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@ComponentScan(basePackages={"com.quinnox.springandhibernateintegration.configuration"})
@EnableWebMvc
public class WebMvcConfig implements WebMvcConfigurer{
	
	@Bean(name="viewResolver")
	public ViewResolver viewResolver(){
		InternalResourceViewResolver internalResourceViewResolver=new InternalResourceViewResolver();
		internalResourceViewResolver.setSuffix("/WEB-INF/views/");
		internalResourceViewResolver.setPrefix(".jsp");
		return internalResourceViewResolver;
	}
	
	
	
}
