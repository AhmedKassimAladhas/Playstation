package com.aladhas.playstation.config;



import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@Configuration
@EnableWebMvc
@ComponentScan("com.aladhas.playstation")
public class WebMvcConfig implements WebMvcConfigurer {

	@Bean(name = "viewResolver")
	public InternalResourceViewResolver getViewResolver() {
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setViewClass(JstlView.class);
		viewResolver.setPrefix("/WEB-INF/views/");
		viewResolver.setSuffix(".jsp");
		viewResolver.setContentType("text/html; charset=UTF-8");
		return viewResolver;
	}	
		
	   @Override
	   public void addResourceHandlers(ResourceHandlerRegistry registry) {
		   
		   // Register resource handler for CSS and JS
		      registry.addResourceHandler("/resources/**").addResourceLocations("classpath:/statics/", "C:/statics/");
//		            .setCacheControl(CacheControl.maxAge(2, TimeUnit.HOURS).cachePublic());
		      
		   // Register resource handler for images
	      registry.addResourceHandler("/img/**").addResourceLocations("/WEB-INF/img/");
//	            .setCacheControl(CacheControl.maxAge(2, TimeUnit.HOURS).cachePublic());
	   }
	   
	   
//	   @Bean
//	   public StringHttpMessageConverter stringHttpMessageConverter() {
//	       return new StringHttpMessageConverter(Charset.forName("UTF-8"));
//	   }	
	 
}
