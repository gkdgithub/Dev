package com.quinnox.springandhibernateintegration.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ComponentScan(basePackages={"com.quinnox.springandhibernateintegration.configuration"})
@PropertySource(value={"classpath:application.properties"})
@EnableTransactionManagement
public class AppContextConfig {
	
}
