package com.jwtreact.jwtreactintegration.common;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.jwtreact.jwtreactintegration.config.JwtInterceptor;

@Configuration
@EnableWebMvc
public class CustomWebConfig implements WebMvcConfigurer {
	@Autowired
	private JwtInterceptor jwtInterceptor;
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(jwtInterceptor);


	}

	/*
	 * @Override public void addCorsMappings(CorsRegistry registry) {
	 * 
	 * registry.addMapping("/api/**").allowedOrigins("http://domain2.com").
	 * allowedMethods("PUT", "DELETE") .allowedHeaders("header1", "header2",
	 * "header3").exposedHeaders("header1", "header2")
	 * .allowCredentials(true).maxAge(3600);
	 * 
	 * // Add more mappings... }
	 */

	@Override
	public void addCorsMappings(CorsRegistry registry) {
		registry.addMapping("/**").allowedOrigins("*");
	}

}
