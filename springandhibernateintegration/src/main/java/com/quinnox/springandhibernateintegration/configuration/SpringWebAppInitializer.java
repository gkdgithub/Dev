package com.quinnox.springandhibernateintegration.configuration;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

// Equivalent to dispatcher Servlet in web.xml
public class SpringWebAppInitializer implements WebApplicationInitializer {

	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		
		// Create the 'root' Spring application context
		AnnotationConfigWebApplicationContext rootContext=new AnnotationConfigWebApplicationContext();
		rootContext.register(AppContextConfig.class);
		//rootContext.setServletContext(servletContext);
		
		 // Manage the lifecycle of the root application context
		servletContext.addListener(new ContextLoaderListener(rootContext));
		
		
		// Create the dispatcher servlet's Spring application context
		AnnotationConfigWebApplicationContext dispatcherContext = new AnnotationConfigWebApplicationContext();
		dispatcherContext.register(WebMvcConfig.class);
		
		ServletRegistration.Dynamic servlet=servletContext.addServlet("dispatcher", new DispatcherServlet(dispatcherContext));
		servlet.setLoadOnStartup(1);
		servlet.addMapping("/");
		
	}

}
