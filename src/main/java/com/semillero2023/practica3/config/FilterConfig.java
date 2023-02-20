package com.semillero2023.practica3.config;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FilterConfig {
	@Bean
	FilterRegistrationBean<JwtFilter> jwtFilter() {
		FilterRegistrationBean<JwtFilter> filter = new FilterRegistrationBean<>();
		filter.setFilter(new JwtFilter());
		filter.addUrlPatterns("/siniestro/*");
		filter.addUrlPatterns("/seguros/*");
		filter.addUrlPatterns("/perito/*");
		filter.addUrlPatterns("/companias/*");
		filter.addUrlPatterns("/companias_seguros/*");
		filter.addUrlPatterns("/clientes/*");
		return filter;
	}
}
