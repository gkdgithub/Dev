package com.quinnox.springandhibernateintegration.configuration;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages={"com.quinnox.springandhibernateintegration.*"})
public class WebMvcConfig implements WebMvcConfigurer{
	
	@Bean(name="viewResolver")
	public ViewResolver viewResolver(){
		InternalResourceViewResolver internalResourceViewResolver=new InternalResourceViewResolver();
		internalResourceViewResolver.setPrefix("/WEB-INF/views/");
		internalResourceViewResolver.setSuffix(".jsp");		
		return internalResourceViewResolver;
	}
	
	// We need to tell spring that any css and js file look under resources folder
	// this line serve all the request coming with URL pattern like => anything/resources/css or js will look
	// under the resources directory (src/main/webapp/resources) 
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
	}
	 
	// Method messageSource configures a Message bundle to support [internationalized] messages from properties file
	// Spring will search message.properties in application classpath
	// We are writing our own custom validation(JSR 303). To enable that we are using ResourceBundleMessageSource
	
	@Bean
	public MessageSource messageSource(){
		ResourceBundleMessageSource bundleMessageSource=new ResourceBundleMessageSource();
		bundleMessageSource.setBasename("message");
		return bundleMessageSource;
	}
	
}
