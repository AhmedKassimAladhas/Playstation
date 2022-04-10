package com.aladhas.playstation.config;


import javax.servlet.FilterRegistration;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.DispatcherServlet;


public class WebAppInitializer implements WebApplicationInitializer {

	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		
		AnnotationConfigWebApplicationContext appContext = new AnnotationConfigWebApplicationContext();
		appContext.register(WebMvcConfig.class);
		
		ServletRegistration.Dynamic dispatcher = servletContext.addServlet(
	 		"SpringDispatcher", new DispatcherServlet(appContext));
		dispatcher.setLoadOnStartup(1);
		dispatcher.addMapping("/");
		//servletContext.addFilter("filterLogin", filterLogin.class).addMappingForUrlPatterns(null, false, "/*");

		FilterRegistration.Dynamic fr = servletContext.addFilter("encodingFilter", CharacterEncodingFilter.class);		
	    fr.setInitParameter("encoding", "UTF-8");
	    fr.setInitParameter("forceEncoding", "true");
	    fr.addMappingForUrlPatterns(null, true, "/*");
	}		    
	
	
//	public void registerCharachterEncodingFilter(ServletContext aContext) {
//	    CharacterEncodingFilter cef = new CharacterEncodingFilter();
//	    cef.setForceEncoding(true);
//	    cef.setEncoding("UTF-8");
//	    aContext.addFilter("charachterEncodingFilter", cef).addMappingForUrlPatterns(null ,true, "/*");
//	}
	
//	protected Filter[] getServletFilters() {
//		// TODO Auto-generated method stub
//		return new Filter[] { new filterLogin() };
//	}



}
