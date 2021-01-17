package com.augen.augen;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.augen.constant.CommonConstant;

@SpringBootApplication
public class AugenApplication {

	public static void main(String[] args) {
		SpringApplication.run(AugenApplication.class, args);
	}
	
	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/books").allowedOrigins(CommonConstant.ORIGIN);
				registry.addMapping("/**").allowedOrigins(CommonConstant.ORIGIN);
				registry.addMapping("/timefactors").allowedOrigins(CommonConstant.ORIGIN);
			}
		};
	}

}
