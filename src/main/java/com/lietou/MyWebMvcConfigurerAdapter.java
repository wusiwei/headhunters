package com.lietou;

import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

//@Configuration
public class MyWebMvcConfigurerAdapter extends WebMvcConfigurerAdapter{

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/product/static/**").addResourceLocations("classpath:/static/");
		super.addResourceHandlers(registry);
	}
	
	

}
